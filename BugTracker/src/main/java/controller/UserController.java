package controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.user.Role;
import model.user.User;
import model.user.UserData;
import service.user.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistration(Model model) {
		Collection<Role> roleList = userService.getRoles();
		
		if(roleList.isEmpty()){
			model.addAttribute("dberror", "Database connection error -"
					+ " site is under maintenance");
		}

		model.addAttribute("roleList", roleList);

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute UserData userRequest) {

		String regexValidator = "^[A-Za-z0-9_-]{3,15}$";

		if (userRequest.getUsername().matches(regexValidator)
				&& userRequest.getPassword().matches(regexValidator)) {

			boolean isUserExisting = userService.isExisting(userRequest.getUsername());

			if (isUserExisting) {
				model.addAttribute("error", "Username is taken!");
			} else {

				User user = new User();
				user.setUsername(userRequest.getUsername());
				user.setFullName(userRequest.getFullName());
				user.setEmail(userRequest.getEmail());
				user.setPassword(userRequest.getPassword());
				user.setRole(userService.getRoleByCode(userRequest.getRole()));

				userService.create(user);
				model.addAttribute("success", "Username successfully created!");
			}

		} else {
			model.addAttribute("error", "Username or password is not valid!");
		}

		return getRegistration(model);
	}

}

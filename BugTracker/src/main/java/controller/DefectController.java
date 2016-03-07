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
import org.springframework.web.bind.annotation.ResponseBody;

import model.defect.Defect;
import model.defect.DefectRequestData;
import model.defect.Severity;
import model.defect.Status;
import service.comment.CommentActionService;
import service.defect.DefectActionService;

@Controller
public class DefectController {

	@Autowired
	DefectActionService defectActionService;

	@Autowired
	CommentActionService commentActionService;

	
	@RequestMapping(value = "/defect", method = RequestMethod.GET)
	public String currencies(Model model) {
		
		Collection<Defect> list = defectActionService.getAll();
		
		model.addAttribute("defectList", list);
		return "list";
	}
	
	@RequestMapping(value = "/defect/add", method = RequestMethod.GET)
	public String add(Model model) {
		
		return "defect-add";
	}
	
	@RequestMapping(value = "/defect/add", method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute 
			DefectRequestData defectRequestData) {
		
		//assignedTo not mandatory
		if (defectRequestData.getTitle().equals("") 
				|| defectRequestData.getDescription().equals("")) {
			model.addAttribute("error", "Required fields are empty!");

			return add(model);
			
		} else {
			

		defectActionService.createDefect(defectRequestData);


		return "redirect:/defect";
		}
	}
	
	@RequestMapping(value = "/defect/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam(value = "id", required = true) int id) {
		
		Defect defect = defectActionService.getDefect(id);
		model.addAttribute("defect", defect);
		
		return "defect-edit";
	}
	
	@RequestMapping(value = "/defect/edit", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute DefectRequestData defectRequestData) {
		
			if (defectRequestData.getTitle().equals("") 
				|| defectRequestData.getDescription().equals("")) {
			model.addAttribute("error", "Required fields are empty!");


			return edit(model, defectRequestData.getId());
		} else {
		
		defectActionService.edit(defectRequestData, 
				defectActionService.getDefect( defectRequestData.getId()));



		return "redirect:/defect";
		}
	}
	
	

}

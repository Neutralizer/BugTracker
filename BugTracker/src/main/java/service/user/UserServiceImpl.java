package service.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dao.user.UserDao;
import model.user.Role;
import model.user.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User userPrincipal = 
				(org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username = userPrincipal.getUsername();
		User user = userDao.findUserByUsername(username);
		return user;
	}

	public String getCurrentUserFullName() {
		org.springframework.security.core.userdetails.User userPrincipal = 
				(org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username = userPrincipal.getUsername();
		User user = userDao.findUserByUsername(username);
		return user.getFullName();
	}

	public Collection<Role> getRoles() {
		return userDao.findRoles();
	}

	public boolean isExisting(String username) {
		User user = userDao.findUserByUsername(username);
		return user != null ? true : false;
	}

	public void create(User userRequest) {
		userDao.add(userRequest);
		
	}

	public Role getRoleByCode(String code) {
		return userDao.findRoleByCode(code);
	}



}

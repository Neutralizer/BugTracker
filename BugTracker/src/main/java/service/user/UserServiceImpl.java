package service.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.user.UserDao;
import model.user.Role;
import model.user.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public String getCurrentUserID() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Role> getRoles() {
		return userDao.findRoles();
	}

	public boolean isExisting(String username) {
		User user = userDao.getUserByUsername(username);
		return user != null ? true : false;
	}

	public void create(User userRequest) {
		userDao.add(userRequest);
		
	}

	public Role getRoleByCode(String code) {
		return userDao.findRoleByCode(code);
	}

}

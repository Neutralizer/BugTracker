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

	public boolean isExisting(User userRequest) {
		User user = userDao.getUserByUsername(userRequest.getUsername());
		return user != null ? true : false;
	}

	public void create(User userRequest) {
		userDao.add(userRequest);
		
	}

}

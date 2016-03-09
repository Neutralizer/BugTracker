package dao.user;

import java.util.Collection;

import model.user.Role;
import model.user.User;

public interface UserDao {

	void add(User user);

	void update(User user);

	void delete(int id);

	User getUser(int id);
	
	User getUserByUsername(String username);
	
	Collection<Role> findRoles();
	
	Role findRoleByCode(String code);

}

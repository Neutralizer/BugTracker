package service.user;

import java.util.Collection;

import model.user.Role;
import model.user.User;

/**
 * 
 * @author Tsetso
 *
 */
public interface UserService {
	
	/**
	 * fetches data about the requested user
	 * @return
	 */
	
	User getCurrentUser();
	
	String getCurrentUserFullName(String username);
	
	Collection<Role> getRoles();

	boolean isExisting(String username);

	void create(User userRequest);
	
	Role getRoleByCode(String code);
}

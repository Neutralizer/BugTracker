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
	String getCurrentUserID();
	
	Collection<Role> getRoles();

	boolean isExisting(User userRequest);

	void create(User userRequest);
}

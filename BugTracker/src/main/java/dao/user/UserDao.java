package dao.user;

import model.user.User;

public interface UserDao {

	void add(User user);

	void update(User user);

	void delete(int id);

	User getUser(int id);

}

package model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserImpl implements User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String position;

	public UserImpl() {
	}

	public UserImpl(String name, String password, String position) {
		this.name = name;
		this.password = password;
		this.position = position;
	}

	public UserImpl(int id, String name, String password, String position) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPosition() {
		return position;
	}

}

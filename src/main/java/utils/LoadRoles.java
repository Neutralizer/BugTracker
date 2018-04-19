package utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dao.HibernateSessionManager;
import model.user.Role;

public class LoadRoles {
	
	public static void main (String [] args) {
		util();
		System.exit(0);
	}

	public static void util() {

		Role role = new Role();
		role.setCode("QA");
		role.setRole("Quality assurance");
		saveRole(role);

		Role role2 = new Role();
		role2.setCode("DEV");
		role2.setRole("Developer");
		saveRole(role2);

		Role role3 = new Role();
		role3.setCode("ADMIN");
		role3.setRole("Administrator");
		saveRole(role3);

	}

	public static void saveRole(Role role) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(role);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	

}

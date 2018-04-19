package dao.user;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dao.HibernateSessionManager;
import model.user.Role;
import model.user.User;

public class UserDaoImpl implements UserDao {

	public void add(User user) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void update(User user) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void delete(int id) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			User defect = session.get(User.class, id);
			session.delete(defect);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public User getUser(int id) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			User user = session.get(User.class, id);
			session.getTransaction().commit();
			return user;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public User findUserByUsername(String username) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			User user = (User) session.createCriteria(User.class)
					.add(Restrictions.eq("username", username)).uniqueResult();
			session.getTransaction().commit();
			return user;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public Collection<Role> findRoles() {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Collection<Role> roles = (Collection<Role>) session.createCriteria(Role.class)
					.list();
			session.getTransaction().commit();
			return roles;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return new ArrayList<Role>();
	}

	public Role findRoleByCode(String code) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Role role = (Role) session.createCriteria(Role.class)
					.add(Restrictions.eq("code", code)).uniqueResult();
			session.getTransaction().commit();
			return role;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

}

package dao.user;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dao.HibernateSessionManager;
import model.defect.Defect;
import model.defect.DefectImpl;
import model.user.User;
import model.user.UserImpl;

public class UserDaoImpl implements UserDao{
	
	public void add(User user){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
	}
	
	public void update(User user){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	public void delete(int id){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			UserImpl defect = session.get(UserImpl.class, id);
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
		try{
			session.beginTransaction();
			UserImpl user = session.get(UserImpl.class, id);
			session.getTransaction().commit();
			return user;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public User getUserByUsername(String username) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			UserImpl user = (UserImpl) session.createCriteria(UserImpl.class)
					.add(Restrictions.eq("username", username));
			session.getTransaction().commit();
			return user;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}
	

}

package dao.genericDao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dao.HibernateSessionManager;

public class GenericDaoImpl<T> implements GenericDao<T> {

	public void add(T obj) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void update(T obj) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

}

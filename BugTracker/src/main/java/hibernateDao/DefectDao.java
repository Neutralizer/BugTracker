package hibernateDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entityAPI.Defect;

public class DefectDao {
	
	public void addDefect(Defect defect){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.save(defect);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
	}
	
	public Collection<Defect> getAllDefects(Defect defect){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			List<Defect> defects = session.createCriteria(Defect.class).list();
			session.getTransaction().commit();
			return defects;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return new ArrayList<Defect>();
	}
	
	public void deleteDefect(int id){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Defect defect = session.get(Defect.class, id);
			session.delete(defect);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
	}
	
	
	
	
	
	
}

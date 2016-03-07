package dao.defect;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dao.HibernateSessionManager;
import model.defect.Defect;
import model.defect.DefectBuilder;
import model.defect.DefectBuilderImpl;
import model.defect.DefectImpl;

public class DefectDaoImpl implements DefectDao{
	
	protected DefectBuilder getDefectBuilder() {
		return new DefectBuilderImpl();
	}
	
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
	
	public void update(Defect defect){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(defect);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	public Collection<Defect> findAllDefects(){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Collection<Defect> defects = session.createCriteria(DefectImpl.class).list();
			session.getTransaction().commit();
			return defects;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return new ArrayList<Defect>();
	}
	
//	public Collection<Defect> findList() {
//		Session session = HibernateSessionManager.getSessionFactory().openSession();
//		try{
//			session.beginTransaction();
////			Collection<Defect> defects = session.createCriteria(DefectImpl.class).list();
//			
//			Query query = session.createQuery("SELECT title, severity, status FROM Defect");
//			ArrayList<Defect> result = (ArrayList<Defect>) query.list();
//			session.getTransaction().commit();
//			return result;
//		} catch (HibernateException e) {
//			session.getTransaction().rollback();
//		} finally {
//			session.close();
//		}
//		return new ArrayList<Defect>();
//	}
	
	public void deleteDefect(int id){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Defect defect = session.get(DefectImpl.class, id);
			session.delete(defect);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
	}

	public Defect findDefect(int id) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			Defect defect = session.get(DefectImpl.class, id);
			session.getTransaction().commit();
			return defect;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	
	
	
	
	
	
	
}

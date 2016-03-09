package dao.defect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

public class DefectDaoImpl implements DefectDao {

	protected DefectBuilder getDefectBuilder() {
		return new DefectBuilderImpl();
	}

	public void addDefect(Defect defect) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(defect);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void update(Defect defect) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(defect);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public Collection<Defect> findAllDefects() {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
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

	@SuppressWarnings("unchecked")
	public Collection<Defect> findList() {
		// defect is using builder, so no constructor for HQL to do its magic
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String hql = "select new list (id, title, severity, status) from DefectImpl";
			List<List> result = (List<List>) session.createQuery(hql).list();
			Collection<Defect> coll = new ArrayList<Defect>();

			for (int r = 0; r < result.size(); r++) {
				Object obj = result.get(r);
				List list = (List) obj;
				Object[] arr = list.toArray();
				Defect defect = getDefectBuilder()
						.id((Integer) arr[0])
						.title((String) arr[1])
						.severity((String) arr[2].toString())
						.status((String) arr[3].toString()).build();
				coll.add(defect);

			}
			session.getTransaction().commit();
			return coll;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return new ArrayList<Defect>();
	}

	public void deleteDefect(int id) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try {
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
		try {
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

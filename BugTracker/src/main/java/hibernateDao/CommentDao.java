package hibernateDao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entityAPI.Comment;
import entityAPI.Defect;
import entityAPI.DefectBuilder;
import entityImpl.DefectBuilderImpl;

public class CommentDao {
	
	protected DefectBuilder getDefectBuilder() {
		return new DefectBuilderImpl();
	}
	
	public void addComment(Comment comment, Defect defect){
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		try{
			Defect def = getDefectBuilder().comment(comment).build(defect);
			session.beginTransaction();
			session.save(def);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		
	}

}

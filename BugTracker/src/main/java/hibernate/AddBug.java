package hibernate;

import org.hibernate.Session;

import entityAPI.Comment;
import entityAPI.CommentActionService;
import entityAPI.Defect;
import entityAPI.DefectActionService;
import entityAPI.DefectRequestData;
import entityAPI.DefectRequestDataBuilder;
import entityAPI.UserService;
import entityImpl.DefectRequestDataBuilderImpl;
import entityImpl.CommentImpl;

public class AddBug {

	public static void main(String[] args) {
		
//		Comment comm = getCommentActionServiceImpl().createComment("text of comment");
//		//create comment after creating the bug
//		DefectRequestData defectRequestData = getDefectRequestDataBuilder()
//				.title("zaglavie").severity("minor")
//				.description("mn lo6 defect s minor severity grin emoticon")
//				.build();
//
//		Defect defect = getDefectActionService().createDefect(defectRequestData);
//		
//		Defect newDefect = getDefectActionService().addComment(defect, comm);
//		
//
//
//		Session session = HibernateSessionManager.getSessionFactory().openSession();
//		session.beginTransaction();
//
//		// probe.setID(11);
//		// probe.setName("Ghost");
//		// probe.setMineralCost(200);
//		// probe.setVespeneCost(100);
//
//		try {
//			session.save(newDefect);
//			session.getTransaction().commit();
//		} catch (Throwable err) {
//			System.err
//					.println("Could not perform operation sdfdfafdsafdadfdfssdaf" + err);
//			HibernateSessionManager.shutdown();
//		}
//
//		HibernateSessionManager.shutdown();
//
//	}
//
//	private static DefectRequestDataBuilder getDefectRequestDataBuilder() {
//		return new DefectRequestDataBuilderImpl();
//	}
//
//	private static UserService getUserServiceImpl() {
//		return new UserService() {
//
//			public String getCurrentUserID() {
//				return "Pesho";
//			}
//		};
//
	}

}

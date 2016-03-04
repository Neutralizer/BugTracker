package defectTest;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import dao.defect.DefectDao;
import dao.defect.DefectDaoImpl;
import model.comment.Comment;
import model.comment.CommentImpl;
import model.defect.Defect;
import model.defect.DefectRequestData;
import model.defect.DefectRequestDataBuilder;
import model.defect.DefectRequestDataBuilderImpl;
import service.defect.DefectActionService;
import service.defect.DefectActionServiceImpl;

public class TestDBDefect {

	DefectActionService defectService = new DefectActionServiceImpl();
	DefectDao dDao = new DefectDaoImpl();

	@Test
	public void testDB() {

		DefectRequestDataBuilder dataBuilder = new DefectRequestDataBuilderImpl();

		DefectRequestData defectRequestData = dataBuilder.author("John").assignedTo("Pesho").title("Oh my god!")
				.severity("MEDIUM").status("NEW").build();

		Defect defect = defectService.createDefect(defectRequestData);

		dDao.addDefect(defect);

		// comment("Peshso..look what have you done!").

		Comment comment = new CommentImpl("Boss of Pesho", "Peshso..look what have you done!");

		Defect defectWithComment = defectService.addComment(defect, comment);

		dDao.update(defectWithComment);

	}
	@Test
	public void addComment() {
		
		Comment comment = new CommentImpl("Boss of Pesho", "Peshso..you are fired!");
		
		Defect defectWithComment = defectService.addComment(dDao.getDefect(1), comment);
		
		dDao.update(defectWithComment);
		
//		Collection<Comment> commentsss = defectWithComment.getComments();
	}
	
	@Test
	public void getComment() {
		Defect defectWithComment = dDao.getDefect(1);
		Collection<Comment> coll = defectWithComment.getComments();
		
		assertEquals(2, coll.size());
	}

}

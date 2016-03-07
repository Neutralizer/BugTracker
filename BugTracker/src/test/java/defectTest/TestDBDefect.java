package defectTest;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.defect.DefectDao;
import dao.defect.DefectDaoImpl;
import model.comment.Comment;
import model.comment.CommentImpl;
import model.defect.Defect;
import model.defect.DefectRequestData;
import service.comment.CommentActionService;
import service.defect.DefectActionService;
import service.defect.DefectActionServiceImpl;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/beans.xml" })
public class TestDBDefect {

	@Autowired
	DefectDao defectDao;
	
	@Autowired
	DefectActionService defectActionService;

	@Autowired
	CommentActionService commentActionService;

	@Test
	public void testDB() {


		DefectRequestData defectRequestData = new DefectRequestData();
		defectRequestData.setTitle("Title 2!");
		defectRequestData.setAuthor("John");
		defectRequestData.setAssignedTo("Pesho");
		defectRequestData.setSeverity("MAJOR");
				

		Defect defect = defectActionService.createDefect(defectRequestData);

//		dDao.addDefect(defect);

		// comment("Peshso..look what have you done!").

		Comment comment = new CommentImpl("Boss of Pesho", "comment1");
		Comment comment2 = new CommentImpl("Boss of Pesho", "comment2");

		Defect defectWithComment = defectActionService.addComment(defect, comment);
		defectWithComment = defectActionService.addComment(defect, comment2);

		defectDao.update(defectWithComment);

	}
	@Test
	public void addComment() {
		
		Comment comment = new CommentImpl("Boss of Pesho", "Peshso..you are fired!");
		
		Defect defectWithComment = defectActionService.addComment(defectDao.findDefect(1), comment);
		
		defectDao.update(defectWithComment);
		
//		Collection<Comment> commentsss = defectWithComment.getComments();
	}
	
	@Test
	public void getComment() {
		Defect defectWithComment = defectDao.findDefect(1);
		Collection<Comment> coll = defectWithComment.getComments();
		
		assertEquals(2, coll.size());
	}
	
	
	@Test
	public void getList() {
		Collection<Defect> coll = defectActionService.getAll();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}

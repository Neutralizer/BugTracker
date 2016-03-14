package defectTest;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Ignore;
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

	@Ignore
	@Test
	public void testDB() {
		//TODO fix test - the test now requires logged in username 

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
		//TODO
		// use update from service
		defectDao.update(defectWithComment);

	}
	
	@Ignore
	@Test
	public void addComment() {
		//TODO fix test - the test now requires logged in username 
		
		Comment comment = new CommentImpl("Boss of Pesho", "Peshso..you are fired!");
		
		Defect defectWithComment = defectActionService.addComment(defectDao.findDefect(1), comment);
		
		defectDao.update(defectWithComment);
		
//		Collection<Comment> commentsss = defectWithComment.getComments();
	}
	
	@Ignore
	@Test
	public void getComment() {
		//TODO fix test - the test now requires logged in username 
		Defect defectWithComment = defectDao.findDefect(1);
		Collection<Comment> coll = defectWithComment.getComments();
		
		assertEquals(2, coll.size());
	}
	
	@Ignore
	@Test
	public void getAll() {
		//TODO fix test - the test now requires logged in username 
		Collection<Defect> coll = defectActionService.getAll();
		
		
		
	}
	
	@Ignore
	@Test
	public void getList(){
		//TODO fix test - the test now requires logged in username 
		
		Collection<Defect> coll = defectActionService.getList();
		
		assertEquals(2, coll.size());
		
	}
	
	
	
	
	
	
	
	
	
	
	

}

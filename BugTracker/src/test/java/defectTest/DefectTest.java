package defectTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import entityAPI.Comment;
import entityAPI.CommentActionService;
import entityAPI.Defect;
import entityAPI.DefectActionService;
import entityAPI.DefectRequestDataBuilder;
import entityAPI.UserService;
import entityImpl.DefectRequestDataBuilderImpl;
import entityAPI.DefectRequestData;

public class DefectTest {

	@Test
	public void testDefectRequestData() {

//		DefectRequestData defectRequestData = getDefectRequestDataBuilder()
//				.title("zaglavie").severity("minor")
//				.description("mn lo6 defect s minor severity grin emoticon").build();
//
//		Defect defect = getDefectActionService().createDefect(defectRequestData);
//		assertNotNull(defect);
//		assertEquals("zaglavie", defect.getTitle());
	}

	@Test
	public void testDefectAddComment(){
//		DefectRequestData defectRequestData = getDefectRequestDataBuilder()
//				.title("zaglavie")
//				.severity("minor")
//				.description("mn lo6 defect s minor severity grin emoticon")
//				.build();
//		
//		Defect defect = getDefectActionService().createDefect(defectRequestData);
//		
//		Comment comm = getCommentActionServiceImpl().createComment("svej nov komentar");
//
//		Defect newDefect = getDefectActionService().addComment(defect, comm);
//		
//		assertTrue(newDefect.getComments().contains(comm));
//		
//		Comment newComm = getCommentActionServiceImpl().createComment("oshte po - svej nov komentar");
//		
//		Defect newerDefect = getDefectActionService().addComment(defect, newComm);
//		
//		Collection<Comment> comments = new ArrayList<Comment>();
//		
//		comments.add(comm);
//		comments.add(newComm);
//		
//		assertEquals(newerDefect.getComments(), comments);
	}

	

	private DefectRequestDataBuilder getDefectRequestDataBuilder() {
		return new DefectRequestDataBuilderImpl();
	}

	// @Test
	// public void testAddComment() {
	// String commentText = "blq blq blq";
	// Defect defect getDefectActionService()
	// .addComment(commentText);
	// assert.assertNotNull(defect);
	// assert.assertEquals(1, defect.getComments.size);
	// Comment comment = defect.getComments.iterator.next;
	// //tva ti vra6ta parviq element
	// Assert.assertEquals("blq blq blq", comment .getText);
	// }

}

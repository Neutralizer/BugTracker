package service.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.defect.DefectDao;
import model.comment.Comment;
import model.comment.CommentImpl;
import service.user.UserService;

/**
 * creates a new comment and edits it
 * 
 * @author Tsetso
 * 
 */

@Service
public class CommentActionServiceImpl implements CommentActionService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DefectDao dao;
	
	

	public Comment createComment(String text) {
		Comment comm = new CommentImpl(userService.getCurrentUserID(), text);
		return comm;
	}

	public Comment edit(String text, Comment comment) {
		Comment comm = new CommentImpl(comment, text);
		
		return comm;
	}

}

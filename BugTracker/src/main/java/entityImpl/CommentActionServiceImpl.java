package entityImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entityAPI.Comment;
import entityAPI.CommentActionService;
import entityAPI.UserService;

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

	public Comment createComment(String text) {
		Comment comm = new CommentImpl(userService.getCurrentUserID(), text);
		return comm;
	}

	public Comment edit(String text, Comment comment) {
		Comment comm = new CommentImpl(comment, text);
		return comm;
	}

}

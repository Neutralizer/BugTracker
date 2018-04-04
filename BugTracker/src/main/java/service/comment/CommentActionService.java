package service.comment;

import java.util.Date;

import model.comment.Comment;

public interface CommentActionService {

	Comment createComment(String author, String text);

	/**
	 * edits the content of the selected comment
	 * 
	 * @param text
	 *            - new text to the comment
	 * @param comment
	 *            - the comment that will be changed
	 * @returns the edited comment
	 */
	Comment edit(String text, Comment comment);

}

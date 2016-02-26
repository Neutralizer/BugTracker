package entityAPI;

import java.util.Date;

public interface CommentActionService {

	Comment createComment(String text);

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

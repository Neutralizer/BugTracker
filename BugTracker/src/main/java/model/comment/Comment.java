package model.comment;

import java.util.Date;

public interface Comment {
	
	int getId();
	
	String getAuthor();

	Date getCreationDate();
	
	String getText();
	
	Date getLastChangedDate();

}

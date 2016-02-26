package entityAPI;

import java.util.Date;

public interface Comment {
	

	String getAuthor();

	Date getCreationDate();
	
	String getText();
	
	Date getLastChangedDate();

}

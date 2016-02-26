package entityAPI;

import java.util.Collection;
import java.util.Date;

public interface Defect {

	Severity getSeverity();

	String getTitle();

	String getDescription();

	String getAuthor();

	Date getDateCreated();

	String getAssignedTo();

	Status getStatus();

	Date getLastChangedDate();

	Collection<Comment> getComments();

}

package model.defect;

import java.util.Collection;
import java.util.Date;

import model.Severity;
import model.Status;
import model.comment.Comment;

public interface Defect {
	
	int getId();

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

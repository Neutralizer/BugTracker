package model.defect;

import java.util.Collection;
import java.util.Date;

import model.comment.Comment;

public interface Defect {
	
	int getId();

	Severity getSeverity();

	String getTitle();

	String getDescription();

	String getAuthor();

	String getDateCreated();

	String getAssignedTo();

	Status getStatus();

	String getLastChangedDate();

	Collection<Comment> getComments();

}

package model.defect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.comment.Comment;
import model.comment.CommentImpl;

@Entity
@Table(name = "defect")
public class DefectImpl implements Defect, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String title;
	String description;
	String author;
	Date dateCreated;
	String assignedTo;
	Status status;
	Severity severity;
	Date lastChangedDate;
	@ElementCollection(targetClass = CommentImpl.class , fetch = FetchType.EAGER)
	Collection<Comment> comments = new ArrayList<Comment>();
	
	public DefectImpl() {
	}

	public int getId() {
		return id;
	}

	public Severity getSeverity() {
		return severity;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getAuthor() {
		return author;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public Status getStatus() {
		return status;
	}

	public Date getLastChangedDate() {
		return lastChangedDate;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

}

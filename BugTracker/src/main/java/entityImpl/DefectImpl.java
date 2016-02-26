package entityImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import entityAPI.Comment;
import entityAPI.Defect;
import entityAPI.Severity;
import entityAPI.Status;

@Entity
class DefectImpl implements Defect, Serializable {

	Severity severity;
	@Id
	String title;
	String description;
	String author;
	Date dateCreated;
	String assignedTo;
	Status status;
	Date lastChangedDate;
	@ElementCollection(targetClass=CommentImpl.class)
	Collection<Comment> comments = new ArrayList<Comment>();

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

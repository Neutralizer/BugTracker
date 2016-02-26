package entityImpl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import entityAPI.Comment;
@Entity
public class CommentImpl implements Comment {

	private String author;
	private Date creationDate;
	private Date lastChangedDate;
	@Id
	private String text;

	public CommentImpl(String author, String text) {
		this.author = author;
		this.creationDate = new Date();
		this.text = text;
		this.lastChangedDate = creationDate;
	}

	public CommentImpl(Comment comment, String text) {
		this.author = comment.getAuthor();
		this.creationDate = comment.getCreationDate();
		this.text = text;
		this.lastChangedDate = new Date();
	}

	public String getAuthor() {
		return author;
	}

	public String getText() {
		return text;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getLastChangedDate() {
		return lastChangedDate;
	}

}

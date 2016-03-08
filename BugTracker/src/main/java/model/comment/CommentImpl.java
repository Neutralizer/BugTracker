package model.comment;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;



@Embeddable
@Table(name = "comment")
public class CommentImpl implements Comment {

//	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String author;
	private Date creationDate;
	private Date lastChangedDate;
	private String text;

	public CommentImpl() {
	}
	
	public CommentImpl( String text) {
		this.author = "new Author (in commentImpl)";
		this.creationDate = new Date();
		this.text = text;
		this.lastChangedDate = creationDate;
	}

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

	public int getId() {
		return id;
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

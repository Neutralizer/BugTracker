package model.defect;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.comment.Comment;

public class DefectBuilderImpl implements DefectBuilder {

	int id;
	Severity severity;
	String title;
	String description;
	String author;
	String assignedTo;
	Status status;
	Comment comment;

	public DefectBuilder id(int id) {
		this.id = id;
		return this;

	}

	public DefectBuilder severity(String severity) {
		if (severity != null) {
			this.severity = Severity.valueOf(severity.toUpperCase());
		}
		return this;
	}

	public DefectBuilder title(String title) {
		this.title = title;
		return this;
	}

	public DefectBuilder description(String description) {
		this.description = description;
		return this;
	}

	public DefectBuilder author(String author) {
		this.author = author;
		return this;
	}

	public DefectBuilder assignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
		return this;
	}

	public DefectBuilder status(String status) {
		if (status != null) {
			this.status = Status.valueOf(status.toUpperCase());
		} else {
			this.status = Status.NEW;
		}
		return this;
	}

	public DefectBuilder comment(Comment comment) {
		this.comment = comment;
		return this;
	}

	public Defect build() {
		SimpleDateFormat formatter = new SimpleDateFormat("y-MM-d H:m");

		DefectImpl defect = new DefectImpl();
		defect.id = this.id;
		defect.title = this.title;
		defect.description = this.description;
		defect.author = this.author;
		defect.dateCreated = formatter.format(new Date());
		defect.assignedTo = this.assignedTo;
		defect.severity = this.severity;
		defect.status = this.status;
		defect.lastChangedDate = formatter.format(new Date());

		return defect;
	}

	public Defect build(Defect olddefect) {
		SimpleDateFormat formatter = new SimpleDateFormat("y-MM-d H:m");
		DefectImpl newDefect = copyDefectData(olddefect);

		if (this.severity != null) {
			newDefect.severity = this.severity;
		}

		if (this.title != null) {
			newDefect.title = this.title;
		}

		if (this.description != null) {
			newDefect.description = this.description;
		}

		if (this.author != null) {
			newDefect.author = this.author;
		}

		if (this.assignedTo != null) {
			newDefect.assignedTo = this.assignedTo;
		}

		if (this.status != null) {
			newDefect.status = this.status;
		}

		newDefect.lastChangedDate = formatter.format(new Date());

		if (this.comment != null) {
			newDefect.comments.add(this.comment);
		}

		return newDefect;
	}

	private DefectImpl copyDefectData(Defect defect) {
		DefectImpl newDefect = new DefectImpl();
		newDefect.id = defect.getId();
		newDefect.severity = defect.getSeverity();
		newDefect.title = defect.getTitle();
		newDefect.description = defect.getDescription();
		newDefect.author = defect.getAuthor();
		newDefect.dateCreated = defect.getDateCreated();
		newDefect.assignedTo = defect.getAssignedTo();
		newDefect.status = defect.getStatus();
		newDefect.lastChangedDate = defect.getLastChangedDate();
		newDefect.comments = defect.getComments();

		return newDefect;

	}

}

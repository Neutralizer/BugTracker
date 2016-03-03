package model.defect;

import java.util.Date;


public class DefectRequestDataBuilderImpl implements DefectRequestDataBuilder {

	String severity;
	String title;
	String description;
	String author;
	String assignedTo;
	String status;
	String lastChangedDate;
	String comment;

	public DefectRequestDataBuilder severity(String severity) {
		this.severity = severity;
		return this;
	}

	public DefectRequestDataBuilder title(String title) {
		this.title = title;
		return this;
	}

	public DefectRequestDataBuilder description(String description) {
		this.description = description;
		return this;
	}

	public DefectRequestDataBuilder author(String author) {
		this.author = author;
		return this;
	}

	public DefectRequestDataBuilder assignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
		return this;
	}

	public DefectRequestDataBuilder status(String status) {
		this.status = status;
		return this;
	}

	public DefectRequestDataBuilder lastChangedDate(String date) {
		this.lastChangedDate = date;
		return this;
	}

	public DefectRequestDataBuilder comment(String comment) {
		this.comment = comment;
		return this;
	}

	public DefectRequestData build() {

		DefectRequestDataImpl defect = new DefectRequestDataImpl();
		defect.severity = this.severity;
		defect.title = this.title;
		defect.description = this.description;
		defect.author = this.author;
		defect.dateCreated = new Date().toString();
		defect.assignedTo = this.assignedTo;
		defect.status = this.status;
		defect.lastChangedDate = this.lastChangedDate;

		return defect;
	}

}

class DefectRequestDataImpl implements DefectRequestData {

	String severity;
	String title;
	String description;
	String author;
	String dateCreated;
	String assignedTo;
	String status;
	String lastChangedDate;
	String comments;

	public String getSeverity() {
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

	public String getDateCreated() {
		return dateCreated;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public String getStatus() {
		return status;
	}

	public String getLastChangedDate() {
		return lastChangedDate;
	}

	public String getComments() {
		return comments;
	}

}

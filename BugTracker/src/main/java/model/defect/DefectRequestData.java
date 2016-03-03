package model.defect;

import model.Builder;

public interface DefectRequestData extends Builder {

	String getSeverity();

	String getTitle();

	String getDescription();

	String getAuthor();

	String getDateCreated();

	String getAssignedTo();

	String getStatus();

	String getLastChangedDate();

	String getComments();

}

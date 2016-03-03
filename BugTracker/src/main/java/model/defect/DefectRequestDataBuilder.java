package model.defect;

import model.Builder;

public interface DefectRequestDataBuilder extends Builder {

	DefectRequestDataBuilder severity(String severity);

	DefectRequestDataBuilder title(String title);

	DefectRequestDataBuilder description(String description);

	DefectRequestDataBuilder author(String author);

	DefectRequestDataBuilder assignedTo(String assignedTo);

	DefectRequestDataBuilder status(String status);

	DefectRequestDataBuilder lastChangedDate(String date);

	DefectRequestDataBuilder comment(String comment);

	DefectRequestData build();

}

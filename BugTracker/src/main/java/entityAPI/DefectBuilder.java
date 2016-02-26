package entityAPI;

public interface DefectBuilder {

	DefectBuilder severity(String severity);

	DefectBuilder title(String title);

	DefectBuilder description(String description);

	DefectBuilder author(String author);

	DefectBuilder assignedTo(String assignedTo);

	DefectBuilder status(String status);

	DefectBuilder comment(Comment comment);
	
	Defect build();
	
	Defect build(Defect defect);

//	Defect build(DefectRequestData defectRequestData);
	
}

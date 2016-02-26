package entityImpl;

import java.util.Date;

import entityAPI.Comment;
import entityAPI.Defect;
import entityAPI.DefectActionService;
import entityAPI.DefectBuilder;
import entityAPI.DefectRequestData;
import entityAPI.Severity;

/**
 * creates a new comment and edits it
 * 
 * @author Tsetso
 *
 */

public class DefectActionServiceImpl implements DefectActionService {

	protected DefectBuilder getDefectBuilder() {
		return new DefectBuilderImpl();
	}
	
	public Defect createDefect(DefectRequestData defectRequestData) {
		Defect defect = getDefectBuilder()
				.severity(defectRequestData.getSeverity())
				.title(defectRequestData.getTitle())
				.description(defectRequestData.getDescription())
				.author(defectRequestData.getAuthor())
				.assignedTo(defectRequestData.getAssignedTo())
				.status(defectRequestData.getStatus())
				.build();
		return defect;

	}

	public Defect edit(DefectRequestData defectRequestData, Defect defect) {
//		Comment comm = new CommentImpl(comment, text);
		Defect newDefect = getDefectBuilder()
				.severity(defectRequestData.getSeverity())
				.title(defectRequestData.getTitle())
				.description(defectRequestData.getDescription())
				.author(defectRequestData.getAuthor())
				.assignedTo(defectRequestData.getAssignedTo())
				.status(defectRequestData.getStatus())
				.build(defect);
		return newDefect;

	}

	public Defect addComment(Defect defect, Comment comment) {
		Defect newDefect = getDefectBuilder()
				.comment(comment)
				.build(defect);
		return newDefect;
	}

}

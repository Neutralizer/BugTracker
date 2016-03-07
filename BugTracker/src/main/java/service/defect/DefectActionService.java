package service.defect;

import java.util.Collection;

import model.comment.Comment;
import model.defect.Defect;
import model.defect.DefectRequestData;

public interface DefectActionService {

	/**
	 * creates a defect from a user given data
	 * @param defectRequestData
	 * @returns a created defect
	 */
	Defect createDefect(DefectRequestData defectRequestData);

	/**
	 * adds a comment to a defect 
	 * @param defect
	 * @param comment
	 * @returns a new defect with added comment
	 */
	Defect addComment(Defect defect, Comment comment);
	
	
	/**
	 * edits a defect
	 * @param defectRequestData - instance of {@link DefectRequestData} holding the changes, that have to be applied
	 * to the defect
	 * @param defect the defect to be changed
	 * @returns a new defect with changes
	 */
	Defect edit(DefectRequestData defectRequestData, Defect defect);
	
	
	/**
	 * 
	 * @returns list of all defects (with parameters - title, severity, status)
	 */
	Collection<Defect> getAll();
	
	/**
	 * 
	 * @param id the id of the defect to be retrieved
	 * @returns the defect with the corresponding id
	 */
	Defect getDefect(int id);
	
	
	
}

package entityAPI;

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
}

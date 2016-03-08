package service.defect;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import dao.defect.DefectDao;
import model.comment.Comment;
import model.comment.CommentImpl;
import model.defect.Defect;
import model.defect.DefectBuilder;
import model.defect.DefectBuilderImpl;
import model.defect.DefectRequestData;

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
	
	@Autowired
	DefectDao defectDao;
	
	public Defect createDefect(DefectRequestData defectRequestData) {
		Defect defect = getDefectBuilder()
				.title(defectRequestData.getTitle())
				.description(defectRequestData.getDescription())
				.severity(defectRequestData.getSeverity())
				.author(defectRequestData.getAuthor())
				.assignedTo(defectRequestData.getAssignedTo())
				.build();
		
		defectDao.addDefect(defect);
		return defect;

	}

	public Defect edit(DefectRequestData defectRequestData, Defect defect) {
		Comment comm = null;
		if(!defectRequestData.getComment().equals("")){
			comm = new CommentImpl(defectRequestData.getComment());
		}
		
		Defect newDefect = getDefectBuilder()
				.severity(defectRequestData.getSeverity())
				.title(defectRequestData.getTitle())
				.description(defectRequestData.getDescription())
				.author(defectRequestData.getAuthor())
				.assignedTo(defectRequestData.getAssignedTo())
				.status(defectRequestData.getStatus())
				.comment(comm)
				.build(defect);
		
		defectDao.update(newDefect);
		return newDefect;

	}

	public Defect addComment(Defect defect, Comment comment) {
		Defect newDefect = getDefectBuilder()
				.comment(comment)
				.build(defect);
		defectDao.update(newDefect);
		return newDefect;
	}

	public Collection<Defect> getAll() {
		
		Collection<Defect> list = defectDao.findAllDefects();
		return list;
	}

	public Defect getDefect(int id) {
		return defectDao.findDefect(id);
	}

	public void delete(int id) {
		defectDao.deleteDefect(id);
	}
	
	public Collection<Defect> getList() {
		
		Collection<Defect> list = defectDao.findList();
		return list;
	}
	
	
//	public Defect editComment(Defect defect, Comment editedComment, ){
//		
//	}

}

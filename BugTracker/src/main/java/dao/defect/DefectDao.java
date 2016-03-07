package dao.defect;

import java.util.Collection;

import model.defect.Defect;

public interface DefectDao {

	void addDefect(Defect defect);
	
	void update(Defect defect);
	
	Collection<Defect> findAllDefects();
	
//	Collection<Defect> findList();
	
	Defect findDefect(int id);
	
	void deleteDefect(int id);
}

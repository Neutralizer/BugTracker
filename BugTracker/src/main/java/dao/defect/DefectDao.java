package dao.defect;

import java.util.Collection;

import model.defect.Defect;

public interface DefectDao {

	void addDefect(Defect defect);
	
	void update(Defect defect);
	
	Collection<Defect> getAllDefects(Defect defect);
	
	Defect getDefect(int id);
	
	void deleteDefect(int id);
}

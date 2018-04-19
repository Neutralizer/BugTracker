package dao.defect;

import java.util.Collection;

import dao.genericDao.GenericDao;
import model.defect.Defect;

public interface DefectDao{

	void addDefect(Defect defect);
	
	void update(Defect defect);
	
	Collection<Defect> findAllDefects();
	
	Defect findDefect(int id);
	
	void deleteDefect(int id);
	
	Collection<Defect> findList();
	
	Collection<Defect> findAllLike(String key);
}

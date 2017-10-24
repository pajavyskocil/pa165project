package cz.fi.muni.pa165.dao;

import cz.fi.muni.pa165.entity.Area;
import cz.fi.muni.pa165.enums.AreaType;

import java.util.List;

public interface AreaDao {
	void create(Area area);
	void delete(Area area);
	Area findById(Long id);
	List<Area> getAllForType(AreaType areaType);
	List<Area> getAll();
}

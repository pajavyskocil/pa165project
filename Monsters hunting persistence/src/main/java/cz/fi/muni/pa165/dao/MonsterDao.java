package cz.fi.muni.pa165.dao;

import cz.fi.muni.pa165.entity.Monster;
import cz.fi.muni.pa165.enums.MonsterAgility;

import java.util.List;

public interface MonsterDao {
	void create(Monster monster);
	void delete(Monster monster);
	Monster findById(Long id);
	Monster findByName(String name);
	List<Monster> getAllForAgility(MonsterAgility monsterAgility);
	List<Monster> getAll();
}

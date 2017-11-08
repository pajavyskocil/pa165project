package cz.fi.muni.pa165.service;

import cz.fi.muni.pa165.entity.Monster;

import java.util.List;

/**
 * Service interface for managing {@link Monster} entities
 *
 * @author Vojtech Sassmann &lt;vojtech.sassmann@gmail.com&gt;
 */
public interface MonsterService {

	List<Monster> getAllMonsters();

	void createMonster(Monster monster);

	List<Monster> getTheMostWidespreadMonsters();
}

package cz.fi.muni.pa165.facade;

import cz.fi.muni.pa165.dto.MonsterCreateDTO;
import cz.fi.muni.pa165.dto.MonsterDTO;

import java.util.List;

/**
 * Facade interface for {@link MonsterDTO} entities.
 *
 * @author Vojtech Sassmann &lt;vojtech.sassmann@gmail.com&gt;
 */
public interface MonsterFacade {

	List<MonsterDTO> getAllMonsters();

	Long createMonster(MonsterCreateDTO monster);
}

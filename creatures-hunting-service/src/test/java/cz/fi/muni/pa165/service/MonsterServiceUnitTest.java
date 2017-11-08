package cz.fi.muni.pa165.service;

import cz.fi.muni.pa165.dao.MonsterDao;
import cz.fi.muni.pa165.entity.Area;
import cz.fi.muni.pa165.entity.Monster;
import org.mockito.InjectMocks;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MonsterServiceUnitTest {

	private MonsterDao monsterDao = mock(MonsterDao.class);

	@InjectMocks
	private MonsterService monsterService;

	private Monster zombie;
	private Monster headlessChicken;
	private Monster spider;

	@BeforeMethod
	public void setService() {
		monsterService = new MonsterServiceImpl(monsterDao);
	}

	@BeforeMethod
	public void createEntities() {
		Area a1 = new Area("Desert");
		Area a2 = new Area("Forest");

		zombie = new Monster("Zombie");
		headlessChicken = new Monster("Headless Chicken");
		spider = new Monster("Spider");

		zombie.addArea(a1);
		zombie.addArea(a2);

		spider.addArea(a1);
		spider.addArea(a2);

		headlessChicken.addArea(a1);
	}

	@Test
	public void testGetTheMostWidespreadMonsters() {
		when(monsterDao.getAll()).thenReturn(Arrays.asList(zombie, headlessChicken, spider));

		List<Monster> mostWidespreadMonsters = monsterService.getTheMostWidespreadMonsters();
		assertThat(mostWidespreadMonsters).containsOnly(zombie, spider);
	}

	@Test
	public void testGetAllMonsters() {
		when(monsterDao.getAll()).thenReturn(Arrays.asList(zombie, headlessChicken, spider));

		List<Monster> allMonsters = monsterService.getAllMonsters();
		assertThat(allMonsters).containsOnly(zombie, spider, headlessChicken);
	}
}

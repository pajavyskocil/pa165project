package cz.fi.muni.pa165.service.facade;

import cz.fi.muni.pa165.dto.MonsterChangeAgilityDTO;
import cz.fi.muni.pa165.dto.MonsterCreateDTO;
import cz.fi.muni.pa165.dto.MonsterDTO;
import cz.fi.muni.pa165.entity.Monster;
import cz.fi.muni.pa165.enums.MonsterAgility;
import cz.fi.muni.pa165.facade.MonsterFacade;
import cz.fi.muni.pa165.service.BeanMappingService;
import cz.fi.muni.pa165.service.MonsterService;
import org.mockito.InjectMocks;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vojtech Sassmann <vojtech.sassmann@gmail.com>
 */
public class MonsterFacadeUnitTest {

	private MonsterService monsterService = mock(MonsterService.class);
	private BeanMappingService beanMappingService = mock(BeanMappingService.class);

	@InjectMocks
	private MonsterFacade monsterFacade = new MonsterFacadeImpl(monsterService, beanMappingService);

	private MonsterCreateDTO zombieCreateDTO;
	private MonsterDTO zombieDTO;
	private MonsterDTO chickenDTO;
	private Monster zombie;
	private Monster chicken;

	@BeforeMethod
	private void setUp() {
		zombieCreateDTO = new MonsterCreateDTO();
		zombieCreateDTO.setName("Zombie");
		zombieCreateDTO.setHeight(54.0);
		zombieCreateDTO.setWeight(625.1);
		zombieCreateDTO.setAgility(MonsterAgility.FAST);

		zombieDTO = new MonsterDTO();
		zombieDTO.setName(zombieCreateDTO.getName());
		zombieDTO.setHeight(zombieCreateDTO.getHeight());
		zombieDTO.setWeight(zombieCreateDTO.getWeight());
		zombieDTO.setAgility(zombieCreateDTO.getAgility());

		zombie = new Monster();
		zombie.setName(zombieDTO.getName());
		zombie.setHeight(zombieDTO.getHeight());
		zombie.setWeight(zombieDTO.getWeight());
		zombie.setAgility(zombieDTO.getAgility());

		chicken = new Monster();
		chicken.setName("Chick");
		chicken.setId(2L);
		chicken.setAgility(MonsterAgility.SLOW);

		chickenDTO = new MonsterDTO();
	}

	@Test
	public void testCreateMonster() {
		when(beanMappingService.mapTo(zombieCreateDTO, Monster.class)).thenReturn(zombie);

		doAnswer(invocation -> {
			zombie.setId(1L);
			return null;
		}).when(monsterService).createMonster(zombie);

		Long id = monsterFacade.createMonster(zombieCreateDTO);

		verify(monsterService, times(1)).createMonster(zombie);

		assertThat(id).isEqualTo(1L);
	}

	@Test
	public void testGetAllMonsters() {
		when(monsterService.getAllMonsters()).thenReturn(Arrays.asList(zombie, chicken));
		when(beanMappingService.mapTo(any(), eq(MonsterDTO.class))).thenReturn(Arrays.asList(zombieDTO, chickenDTO));

		assertThat(monsterFacade.getAllMonsters()).containsOnly(zombieDTO, chickenDTO);
	}

	@Test
	public void testDeleteMonster() {
		Long id = 1L;

		when(monsterService.findById(id)).thenReturn(zombie);

		monsterFacade.deleteMonster(id);

		verify(monsterService).deleteMonster(zombie);
	}

	@Test
	public void testChangeMonsterAgility() {
		MonsterChangeAgilityDTO change = new MonsterChangeAgilityDTO(zombie.getId(), MonsterAgility.SLOW);
		when(monsterService.findById(change.getMonsterId())).thenReturn(zombie);

		monsterFacade.changeMonsterAgility(change);

		assertThat(zombie.getAgility()).isEqualTo(MonsterAgility.SLOW);
	}

	@Test
	public void testGetAllForAgility() {
		when(monsterService.getAllForAgility(MonsterAgility.SLOW)).thenReturn(Collections.singletonList(chicken));
		when(beanMappingService.mapTo(any(), eq(MonsterDTO.class))).thenReturn(Collections.singletonList(chickenDTO));

		List<MonsterDTO> slowMonsters = monsterFacade.getAllForAgility(MonsterAgility.SLOW);
		assertThat(slowMonsters).containsOnly(chickenDTO);
	}

	@Test
	public void testFindById() {
		Long id = 1L;

		when(monsterService.findById(id)).thenReturn(zombie);
		when(beanMappingService.mapTo(zombie, MonsterDTO.class)).thenReturn(zombieDTO);

		MonsterDTO foundMonster = monsterFacade.findById(id);

		assertThat(foundMonster).isEqualToComparingFieldByField(zombieDTO);
	}

	@Test
	public void testFindByName() {
		String name = "Zombie";

		when(monsterService.findByName(name)).thenReturn(zombie);
		when(beanMappingService.mapTo(zombie, MonsterDTO.class)).thenReturn(zombieDTO);

		MonsterDTO foundMonster = monsterFacade.findByName(name);

		assertThat(foundMonster).isEqualToComparingFieldByField(zombieDTO);
	}

	@Test
	public void testGetTheMostWidespreadMonsters() {
		when(monsterService.getTheMostWidespreadMonsters()).thenReturn(Arrays.asList(chicken, zombie));
		when(beanMappingService.mapTo(any(), eq(MonsterDTO.class))).thenReturn(Arrays.asList(chickenDTO, zombieDTO));

		List<MonsterDTO> monsters = monsterFacade.getTheMostWidespreadMonsters();

		assertThat(monsters).containsOnly(chickenDTO, zombieDTO);
	}
}

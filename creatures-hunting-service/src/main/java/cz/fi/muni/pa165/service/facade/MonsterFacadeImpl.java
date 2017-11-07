package cz.fi.muni.pa165.service.facade;

import cz.fi.muni.pa165.dto.MonsterCreateDTO;
import cz.fi.muni.pa165.dto.MonsterDTO;
import cz.fi.muni.pa165.entity.Monster;
import cz.fi.muni.pa165.facade.MonsterFacade;
import cz.fi.muni.pa165.service.BeanMappingService;
import cz.fi.muni.pa165.service.MonsterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class MonsterFacadeImpl implements MonsterFacade {

	private final MonsterService monsterService;

	private final BeanMappingService beanMappingService;

	@Inject
	public MonsterFacadeImpl(MonsterService monsterService, BeanMappingService beanMappingService) {
		this.monsterService = monsterService;
		this.beanMappingService = beanMappingService;
	}

	@Override
	public List<MonsterDTO> getAllMonsters() {
		return beanMappingService.mapTo(monsterService.getAllMonsters(), MonsterDTO.class);
	}

	@Override
	public Long createMonster(MonsterCreateDTO monster) {
		Monster mappedMonster = beanMappingService.mapTo(monster, Monster.class);
		monsterService.createMonster(mappedMonster);
		return mappedMonster.getId();
	}
}

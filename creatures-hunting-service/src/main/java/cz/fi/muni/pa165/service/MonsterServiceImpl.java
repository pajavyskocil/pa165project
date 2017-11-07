package cz.fi.muni.pa165.service;

import cz.fi.muni.pa165.dao.MonsterDao;
import cz.fi.muni.pa165.entity.Monster;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {

	private final MonsterDao monsterDao;

	@Inject
	public MonsterServiceImpl(MonsterDao monsterDao) {
		this.monsterDao = monsterDao;
	}

	@Override
	public List<Monster> getAllMonsters() {
		return monsterDao.getAll();
	}

	@Override
	public void createMonster(Monster monster) {
		monsterDao.create(monster);
	}
}

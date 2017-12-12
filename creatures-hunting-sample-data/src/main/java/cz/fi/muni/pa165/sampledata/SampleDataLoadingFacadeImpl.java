package cz.fi.muni.pa165.sampledata;

import cz.fi.muni.pa165.entity.Monster;
import cz.fi.muni.pa165.entity.User;
import cz.fi.muni.pa165.enums.MonsterAgility;
import cz.fi.muni.pa165.enums.UserRole;
import cz.fi.muni.pa165.service.MonsterService;
import cz.fi.muni.pa165.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {

	private final MonsterService monsterService;
	private final UserService userService;

	@Inject
	public SampleDataLoadingFacadeImpl(MonsterService monsterService, UserService userService) {
		this.monsterService = monsterService;
		this.userService = userService;
	}

	@Override
	public void loadData() {

		loadUsers();

		Monster zombie = new Monster("Zombie");
		Monster headlessChicken = new Monster("Headless Chicken");
		Monster rat = new Monster("Rat");
		Monster spider = new Monster("Spider");
		Monster mom = new Monster("Mom");

		zombie.setWeight(5.4);
		headlessChicken.setWeight(5.6);
		spider.setWeight(5.3);
		mom.setWeight(1.4);

		zombie.setHeight(5.4);
		headlessChicken.setHeight(5.6);
		rat.setHeight(8.4);
		spider.setHeight(5.3);


		headlessChicken.setAgility(MonsterAgility.FAST);
		rat.setAgility(MonsterAgility.SLOW);
		spider.setAgility(MonsterAgility.FAST);
		mom.setAgility(MonsterAgility.SLOW);

		monsterService.createMonster(zombie);
		monsterService.createMonster(headlessChicken);
		monsterService.createMonster(rat);
		monsterService.createMonster(spider);
		monsterService.createMonster(mom);
	}

	private void loadUsers() {
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();

		user1.setFirstName("Alojz");
		user1.setLastName("Hlinka");
		user1.setEmail("alojz@hlinka.com");
		user1.setRole(UserRole.ADMIN);

		user2.setFirstName("Jozef");
		user2.setLastName("Mak");
		user2.setEmail("jozef@mak.com");
		user2.setRole(UserRole.ADMIN);

		user3.setFirstName("Lucia");
		user3.setLastName("Srnova");
		user3.setEmail("lucia@srnova.com");

		userService.registerUser(user1, "1234");
		userService.registerUser(user2, "1234");
		userService.registerUser(user3, "1234");
	}
}

package cz.fi.muni.pa165.dao;


import cz.fi.muni.pa165.PersistenceApplicationContext;
import cz.fi.muni.pa165.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes=PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class UserDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private UserDao userDao;

	@PersistenceContext
	private EntityManager em;

	@Test
	public void getAll() {
		User user1 = new User("Jan", "Hus", "jan.hus@upal.me");

		userDao.create(user1);

		List<User> users = userDao.getAll();

		assertThat(user1).isEqualToComparingFieldByField(users.get(0));
	}
}

package cz.fi.muni.pa165.service.facade;

import cz.fi.muni.pa165.dao.MonsterDao;
import cz.fi.muni.pa165.service.MonsterService;
import cz.fi.muni.pa165.service.config.ServiceConfiguration;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;


@ContextConfiguration(classes=ServiceConfiguration.class)
public class MonsterServiceUnitTest extends AbstractTransactionalTestNGSpringContextTests {

	@Mock
	private MonsterDao monsterDao;

	@InjectMocks
	private MonsterService monsterService;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}


}

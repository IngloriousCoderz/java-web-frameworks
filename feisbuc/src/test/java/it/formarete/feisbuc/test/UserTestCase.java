package it.formarete.feisbuc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import it.formarete.feisbuc.model.User;
import it.formarete.feisbuc.service.UserDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTestCase {
	private ClassPathXmlApplicationContext context;
	private UserDao userDao;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void testCrud() {
		userDao.clear();
		assertTrue(userDao.getAll().isEmpty());

		User user = new User();
		user.setName("admin");
		user.setPassword("admin");

		int id = userDao.save(user);
		assertTrue(id > 0);

		user = userDao.get("admin");
		assertNotNull(user);

		user.setPassword("nimda");
		userDao.update(user);

		user = userDao.get("admin");
		assertEquals("nimda", user.getPassword());

		userDao.delete("admin");

		user = userDao.get("admin");
		assertNull(user);
	}

	@After
	public void tearDown() {
		context.close();
	}
}

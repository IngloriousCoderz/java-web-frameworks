package it.formarete.feisbuc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
		user.setName("antony");
		user.setPassword("mistretta");

		int id = userDao.save(user);
		assertTrue(id > 0);

		user = userDao.get("antony");
		assertNotNull(user);

		user.setPassword("attertsim");
		userDao.update(user);

		user = userDao.get("antony");
		assertEquals("attertsim", user.getPassword());

		userDao.delete("antony");

		user = userDao.get("antony");
		assertNull(user);
	}

	@Test
	public void testFriends() {
		userDao.clear();

		User user = new User();
		user.setName("antony");
		user.setPassword("mistretta");
		userDao.save(user);

		User friend = new User();
		friend.setName("fabrizio");
		friend.setPassword("ravalli");
		userDao.save(friend);

		user = userDao.get("antony");
		friend = userDao.get("fabrizio");
		userDao.addFriend(user, friend);

		user = userDao.get("antony");
		assertFalse(user.getFriends().isEmpty());
	}

	@After
	public void tearDown() {
		context.close();
	}
}

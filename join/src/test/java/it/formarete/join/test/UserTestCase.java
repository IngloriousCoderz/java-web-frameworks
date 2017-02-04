package it.formarete.join.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import it.formarete.join.model.User;
import it.formarete.join.service.UserDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTestCase {

	private ClassPathXmlApplicationContext context;
	private UserDAO dao;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (UserDAO) context.getBean("userDao");
	}

	@Test
	public void testCrud() {
		dao.clear();
		assertTrue(dao.getAll().isEmpty());

		User user = (User) context.getBean("user");
		user.setName("admin");
		user.setPassword("admin");

		int id = dao.save(user);
		assertTrue(id > 0);

		user = dao.get("admin");
		assertNotNull(user);

		user.setPassword("nimda");
		dao.update(user);

		user = dao.get("admin");
		assertEquals("nimda", user.getPassword());

		dao.delete(user);
//		 dao.deleteByName(user.getName());
//		 dao.deleteByNameHQL(user.getName());

		user = dao.get("admin");
		assertNull(user);
	}

	@After
	public void tearDown() {
		context.close();
	}
}

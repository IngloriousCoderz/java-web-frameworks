package it.formarete.test;

import it.formarete.model.User;
import it.formarete.service.UserDAO;

import java.util.List;

import junit.framework.TestCase;

public class UserDAOTestCase extends TestCase {
	public void testCrud() {
		User user = new User();
		user.setName("Antony");

		/* retrieve */
		UserDAO dao = new UserDAO();
		List<User> users = dao.getAll();
		assertNotNull(users);
		assertTrue(users.isEmpty());

		/* create */
		int id = dao.save(user);
		assertTrue(id > 0);
		user = dao.get(id);
		assertEquals(id, user.getId());
		users = dao.getAll();
		assertEquals(1, users.size());

		/* update */
		user.setName("Matteo");
		dao.update(user);
		user = dao.get(user.getId());
		assertEquals("Matteo", user.getName());
		users = dao.getAll();
		assertEquals(1, users.size());

		/* delete */
		dao.delete(user);
		user = dao.get(user.getId());
		assertNull(user);
		users = dao.getAll();
		assertTrue(users.isEmpty());
	}
}

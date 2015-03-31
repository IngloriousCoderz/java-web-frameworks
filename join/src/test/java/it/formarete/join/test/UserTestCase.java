package it.formarete.join.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import it.formarete.join.model.User;
import it.formarete.join.service.UserDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTestCase {
	private ClassPathXmlApplicationContext context;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testUserCreation() {
		User user = (User) context.getBean("user");
		user.setUsername("giancazzo");

		UserDAO dao = (UserDAO) context.getBean("userDao");
		dao.save(user);

		user = dao.getByUsername("giancazzo");
		assertEquals("giancazzo", user.getUsername());

		dao.delete(user);
		user = dao.getByUsername("giancazzo");
		assertNull(user);
	}

	@After
	public void tearDown() {
		context.close();
	}
}

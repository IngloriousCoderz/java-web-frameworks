package it.formarete.mytodos.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import it.formarete.mytodos.model.Todo;
import it.formarete.mytodos.model.User;
import it.formarete.mytodos.service.TodoDao;
import it.formarete.mytodos.service.UserDao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TodoTestCase {

	private ClassPathXmlApplicationContext context;
	private TodoDao todoDao;
	private UserDao userDao;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		todoDao = (TodoDao) context.getBean("todoDao");
		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void testCrud() {
		User user = new User();
		user.setName("giancarlo");

		userDao.delete(user);
		assertNull(userDao.get(user.getName()));

		userDao.save(user);
		user = userDao.get("giancarlo");

		Todo todo = new Todo();
		todo.setTitle("Learn Struts");
		todo.setOwner(user);

		int id = todoDao.save(todo);
		assertTrue(id > 0);

		List<Todo> todos = todoDao.getAll(user);
		assertNotNull(todos);
		assertFalse(todos.isEmpty());

		todo = todos.get(0);
		todo.setDone(true);
		todoDao.update(todo);

		todos = todoDao.getAll(user);
		assertTrue(todos.get(0).isDone());

		todoDao.delete(id);

		todos = todoDao.getAll(user);
		assertNotNull(todos);
		assertTrue(todos.isEmpty());

		userDao.delete(user);
		assertNull(userDao.get(user.getName()));
	}

	@After
	public void tearDown() {
		context.close();
	}
}

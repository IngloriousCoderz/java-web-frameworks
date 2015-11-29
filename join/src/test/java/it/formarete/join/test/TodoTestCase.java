package it.formarete.join.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import it.formarete.join.model.Todo;
import it.formarete.join.model.User;
import it.formarete.join.service.TodoDAO;
import it.formarete.join.service.UserDAO;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TodoTestCase {
	private ClassPathXmlApplicationContext context;
	private TodoDAO todoDao;
	private UserDAO userDao;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		todoDao = (TodoDAO) context.getBean("todoDao");
		userDao = (UserDAO) context.getBean("userDao");
	}

	@Test
	public void testCrud() {
		todoDao.clear();
		assertTrue(todoDao.getAll().isEmpty());

		userDao.clear();
		assertTrue(userDao.getAll().isEmpty());

		User user = (User) context.getBean("user");
		user.setName("giancarlo");

		userDao.save(user);
		user = userDao.get("giancarlo");

		Todo todo = (Todo) context.getBean("todo");
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
		todo = todos.get(0);
		assertTrue(todo.isDone());

		userDao.delete(user);
		
		todoDao.delete(id);

		todos = todoDao.getAll(user);
		assertNotNull(todos);
		assertTrue(todos.isEmpty());
	}

	@After
	public void tearDown() {
		context.close();
	}
}

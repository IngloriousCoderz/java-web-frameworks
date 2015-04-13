package it.formarete.feisbuc.test;

import static org.junit.Assert.assertTrue;
import it.formarete.feisbuc.model.Post;
import it.formarete.feisbuc.model.User;
import it.formarete.feisbuc.service.PostDao;
import it.formarete.feisbuc.service.UserDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostTestCase {
	private ClassPathXmlApplicationContext context;
	private PostDao postDao;
	private UserDao userDao;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		postDao = (PostDao) context.getBean("postDao");
		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void testCrud() {
		postDao.clear();
		userDao.clear();

		User user = (User) context.getBean("user");
		user.setName("antony");
		user.setPassword("mistretta");

		userDao.save(user);

		Post post = (Post) context.getBean("post");
		post.setText("My first post!");
		post.setOwner(user);

		int id = postDao.save(post);
		assertTrue(id > 0);
	}

	@After
	public void tearDown() {
		context.close();
	}
}

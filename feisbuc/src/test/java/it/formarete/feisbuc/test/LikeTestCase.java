package it.formarete.feisbuc.test;

import static org.junit.Assert.assertTrue;
import it.formarete.feisbuc.model.Like;
import it.formarete.feisbuc.model.Post;
import it.formarete.feisbuc.model.User;
import it.formarete.feisbuc.service.LikeDao;
import it.formarete.feisbuc.service.PostDao;
import it.formarete.feisbuc.service.UserDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LikeTestCase {
	private ClassPathXmlApplicationContext context;
	private LikeDao likeDao;
	private PostDao postDao;
	private UserDao userDao;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		likeDao = (LikeDao) context.getBean("likeDao");
		postDao = (PostDao) context.getBean("postDao");
		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void testCrud() {
		likeDao.clear();
		postDao.clear();
		userDao.clear();

		User poster = (User) context.getBean("user");
		poster.setName("antony");
		poster.setPassword("mistretta");
		int posterId = userDao.save(poster);

		User liker = (User) context.getBean("user");
		liker.setName("fabrizio");
		liker.setPassword("ravalli");
		int likerId = userDao.save(liker);

		Post post = (Post) context.getBean("post");
		post.setText("My first post!");
		post.setOwner(userDao.get(posterId));
		int postId = postDao.save(post);

		Like like = (Like) context.getBean("like");
		like.setOwner(userDao.get(likerId));
		like.setPost(postDao.get(postId));
		likeDao.save(like);

		assertTrue(postDao.get(postId).getLikes() > 0);
	}

	@After
	public void tearDown() {
		context.close();
	}
}

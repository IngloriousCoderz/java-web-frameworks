package it.formarete.feisbuc.action;

import it.formarete.feisbuc.model.Post;
import it.formarete.feisbuc.model.User;
import it.formarete.feisbuc.service.PostDao;
import it.formarete.feisbuc.service.UserDao;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Wall extends ActionSupport {

	private static final long serialVersionUID = -8397577473314811242L;

	private User user;
	private String newPostText;
	private Post post;
	private UserDao userDao;
	private PostDao postDao;

	public User getUser() {
		if (user == null) {
			Integer id = null;
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("uuid")) {
						id = Integer.parseInt(cookie.getValue());
					}
				}
			}
			user = userDao.get(id);
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNewPostText() {
		return newPostText;
	}

	public void setNewPostText(String newPostText) {
		this.newPostText = newPostText;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<Post> getPosts() {
		return postDao.getAll(getUser());
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	@Override
	public String execute() {
		newPostText = null;
		return SUCCESS;
	}

	public String publish() {
		post.setText(newPostText);
		post.setOwner(getUser());
		postDao.save(post);
		return execute();
	}
}

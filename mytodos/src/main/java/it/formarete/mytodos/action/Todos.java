package it.formarete.mytodos.action;

import it.formarete.mytodos.model.Todo;
import it.formarete.mytodos.model.User;
import it.formarete.mytodos.service.TodoDao;
import it.formarete.mytodos.service.UserDao;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Todos extends ActionSupport {
	private static final long serialVersionUID = -1224483568541819071L;

	private TodoDao todoDao;
	private UserDao userDao;
	private String username;
	private Integer id;
	private String title;

	public TodoDao getTodoDao() {
		return todoDao;
	}

	public void setTodoDao(TodoDao todoDao) {
		this.todoDao = todoDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Todo> getTodos() {
		return todoDao.getAll(getUser());
	}

	@Override
	public String execute() {
		title = null;
		id = null;
		return SUCCESS;
	}

	public String submit() {
		return id == null ? create() : update();
	}

	public String create() {
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setOwner(getUser());
		todoDao.save(todo);
		return execute();
	}

	public String update() {
		Todo todo = todoDao.get(id);
		todo.setTitle(title);
		todoDao.update(todo);
		return execute();
	}

	public String edit() {
		Todo todo = todoDao.get(id);
		title = todo.getTitle();
		return SUCCESS;
	}

	public String delete() {
		todoDao.delete(id);
		return execute();
	}

	public String clearConfirm() {
		return "confirm";
	}

	public String clear() {
		todoDao.clear();
		return SUCCESS;
	}

	private User getUser() {
		if (username == null) {
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("login")) {
						username = cookie.getValue();
					}
				}
			}
		}
		return userDao.get(username);
	}
}

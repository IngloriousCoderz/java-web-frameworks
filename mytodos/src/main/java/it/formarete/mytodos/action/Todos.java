package it.formarete.mytodos.action;

import it.formarete.mytodos.model.Todo;
import it.formarete.mytodos.service.TodoDao;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Todos extends ActionSupport {
	private static final long serialVersionUID = -1224483568541819071L;

	private TodoDao dao;
	private Integer id;
	private String title;

	public TodoDao getDao() {
		return dao;
	}

	public void setDao(TodoDao dao) {
		this.dao = dao;
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
		return dao.getAll();
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
		dao.save(todo);
		return execute();
	}

	public String update() {
		Todo todo = dao.get(id);
		todo.setTitle(title);
		dao.update(todo);
		return execute();
	}

	public String edit() {
		Todo todo = dao.get(id);
		title = todo.getTitle();
		return SUCCESS;
	}

	public String delete() {
		dao.delete(id);
		return execute();
	}

	public String clearConfirm() {
		return "confirm";
	}

	public String clear() {
		dao.clear();
		return SUCCESS;
	}
}

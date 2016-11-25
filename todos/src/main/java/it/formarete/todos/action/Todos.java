package it.formarete.todos.action;

import it.formarete.todos.model.Todo;
import it.formarete.todos.service.TodosDB;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Todos extends ActionSupport {

	private static final long serialVersionUID = -1224483568541819071L;

	private final TodosDB db = TodosDB.getInstance();
	private Integer id;
	private String title;

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
		return db.getAll();
	}

	@Override
	public String execute() {
		id = null;
		title = null;
		return SUCCESS;
	}

	public String submit() {
		return id == null ? create() : update();
	}

	public String create() {
		db.create(title);
		return execute();
	}

	public String update() {
		db.update(id, title);
		return execute();
	}

	public String edit() {
		Todo todo = db.get(id);
		title = todo.getTitle();
		return SUCCESS;
	}

	public String delete() {
		db.delete(id);
		return execute();
	}

	public String clear() {
		db.clear();
		return execute();
	}
}

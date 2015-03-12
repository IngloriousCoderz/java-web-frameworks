package it.formarete.todos.action;

import it.formarete.todos.model.Todo;
import it.formarete.todos.service.TodosDB;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Todos extends ActionSupport {
	private static final long serialVersionUID = -1224483568541819071L;

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
		return TodosDB.getInstance().getAll();
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
		TodosDB.getInstance().save(todo);
		return execute();
	}

	public String update() {
		Todo todo = TodosDB.getInstance().get(id);
		todo.setTitle(title);
		TodosDB.getInstance().update(todo);
		return execute();
	}

	public String edit() {
		Todo todo = TodosDB.getInstance().get(id);
		title = todo.getTitle();
		return SUCCESS;
	}

	public String delete() {
		TodosDB.getInstance().delete(id);
		return execute();
	}

	public String clearConfirm() {
		return "confirm";
	}

	public String clear() {
		TodosDB.getInstance().clear();
		return SUCCESS;
	}
}

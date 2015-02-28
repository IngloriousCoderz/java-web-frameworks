package it.formarete.todos.action;

import it.formarete.todos.model.Todo;
import it.formarete.todos.service.TodosDB;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Todos extends ActionSupport {
	private static final long serialVersionUID = -1224483568541819071L;

	private String title;

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
		return SUCCESS;
	}

	public String add() {
		Todo todo = new Todo();
		todo.setTitle(title);
		TodosDB.getInstance().save(todo);
		return execute();
	}

	public String clear() {
		TodosDB.getInstance().clear();
		return execute();
	}
}

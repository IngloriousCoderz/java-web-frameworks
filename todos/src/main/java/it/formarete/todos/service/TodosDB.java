package it.formarete.todos.service;

import it.formarete.todos.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodosDB {
	private static TodosDB singleton;

	private List<Todo> todos;
	private int id;

	public static TodosDB getInstance() {
		if (singleton == null) {
			singleton = new TodosDB();
		}
		return singleton;
	}

	private TodosDB() {
		todos = new ArrayList<Todo>();
		id = 0;
	}

	public int save(Todo todo) {
		todo.setId(++id);
		todos.add(todo);
		return todo.getId();
	}

	public List<Todo> getAll() {
		return todos;
	}

	public void clear() {
		todos.clear();
	}
}

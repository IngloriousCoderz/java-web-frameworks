package it.formarete.todos.service;

import it.formarete.todos.model.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodosDB {
	private static TodosDB singleton;

	private Map<Integer, Todo> todos;
	private int id;

	public static TodosDB getInstance() {
		if (singleton == null) {
			singleton = new TodosDB();
		}
		return singleton;
	}

	private TodosDB() {
		todos = new HashMap<Integer, Todo>();
		id = 0;
	}

	public int save(Todo todo) {
		todo.setId(++id);
		todos.put(id, todo);
		return todo.getId();
	}

	public List<Todo> getAll() {
		return new ArrayList<Todo>(todos.values());
	}

	public void delete(int id) {
		todos.remove(id);
	}

	public void clear() {
		todos.clear();
		id = 0;
	}
}

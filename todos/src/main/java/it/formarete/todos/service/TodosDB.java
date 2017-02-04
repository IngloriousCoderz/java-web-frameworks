package it.formarete.todos.service;

import it.formarete.todos.model.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodosDB {

	private static TodosDB singleton;

	private final Map<Integer, Todo> todos;
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
		create("Learn Struts");
		create("Seek for a job");
		create("Forget everything");
	}

	public Todo get(int id) {
		return todos.get(id);
	}

	public int create(String title) {
		Todo todo = new Todo(title);
		todo.setId(++id);
		return save(todo);
	}

	public int save(Todo todo) {
		todos.put(id, todo);
		return todo.getId();
	}

	public void update(int id, String title) {
		Todo todo = todos.get(id);
		todo.setTitle(title);
		todos.put(id, todo); // useless, but more DB-ish
	}

	public void update(Todo todo) {
		todos.put(todo.getId(), todo);
	}

	public void delete(int id) {
		todos.remove(id);
	}

	public List<Todo> getAll() {
		return new ArrayList<Todo>(todos.values());
	}

	public void clear() {
		todos.clear();
		id = 0;
	}
}

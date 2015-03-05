package it.formarete.todos.service;

import it.formarete.todos.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersDB {
	private static UsersDB singleton;

	private Map<String, User> users;

	public static UsersDB getInstance() {
		if (singleton == null) {
			singleton = new UsersDB();
		}
		return singleton;
	}

	private UsersDB() {
		users = new HashMap<String, User>();
		User user = new User();
		user.setName("admin");
		user.setPassword("admin");
		save(user);
	}

	public User get(String name) {
		return users.get(name);
	}

	public void save(User user) {
		users.put(user.getName(), user);
	}

	public void update(User user) {
		users.put(user.getName(), user);
	}

	public void delete(String name) {
		users.remove(name);
	}

	public List<User> getAll() {
		return new ArrayList<User>(users.values());
	}

	public void clear() {
		users.clear();
	}
}

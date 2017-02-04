package it.formarete.service;

import it.formarete.model.User;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDB {

	private final Map<String, User> users;

	public UsersDB() {
		users = new HashMap<String, User>();
		users.put("giancarlo", new User("giancarlo", "magalli"));
		users.put("pippo", new User("pippo", "baudo"));
	}

	public List<User> getAll() {
		return new ArrayList<User>(users.values());
	}

	public User get(String username) {
		return users.get(username);
	}

	public void add(User user) {
		users.put(user.getUsername(), user);
	}

	public void update(String username, User user) {
		users.put(username, user);
	}

	public void remove(String username) {
		users.remove(username);
	}
}

package it.formarete.service;

import it.formarete.model.User;
import java.util.Collection;

import java.util.HashMap;
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
		user.setUsername("giancarlo");
		user.setPassword("magalli");
		user.setFullname("Giancarlo Magalli");
		users.put(user.getUsername(), user);
	}

	public User get(String username) {
		return users.get(username);
	}
}

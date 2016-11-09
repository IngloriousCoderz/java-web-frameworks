package it.formarete.controller;

import it.formarete.model.User;
import it.formarete.service.UsersDB;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRestController {

    @Autowired
    private UsersDB db;

    @GetMapping("/users")
    public List<User> getAll() {
        return db.getAll();
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable("username") String username) {
        return db.get(username);
    }

    @PostMapping(path = "/users", consumes = "application/json")
    public void addUser(@RequestBody User user) {
        db.add(user);
    }

    @PutMapping(path = "/users/{username}", consumes = "application/json")
    public void updateUser(@PathVariable("username") String username, @RequestBody User user) {
        db.update(username, user);
    }

    @DeleteMapping(path = "/users/{username}")
    public void removeUser(@PathVariable("username") String username) {
        db.remove(username);
    }
}

package it.formarete.feisbuc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String name;
	private String password;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_friends", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
	private List<User> friends;

	// @ManyToMany
	// @JoinTable(name = "user_friends", joinColumns = @JoinColumn(name =
	// "friend_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	// private List<User> friendOf;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	// public List<User> getFriendOf() {
	// return friendOf;
	// }
	//
	// public void setFriendOf(List<User> friendOf) {
	// this.friendOf = friendOf;
	// }

	public void addFriend(User user) {
		if (friends == null) {
			friends = new ArrayList<User>();
		}
		friends.add(user);

		// if (friendOf == null) {
		// friendOf = new ArrayList<User>();
		// }
		// friendOf.add(user);

		if (!user.getFriends().contains(this)) {
			user.addFriend(this);
		}
	}
}

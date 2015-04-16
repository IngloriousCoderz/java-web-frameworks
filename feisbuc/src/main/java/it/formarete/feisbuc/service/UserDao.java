package it.formarete.feisbuc.service;

import it.formarete.feisbuc.model.User;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User get(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public User get(String name) {
		return (User) sessionFactory.getCurrentSession()
				.createQuery("from User where name = :name").setParameter("name", name)
				.uniqueResult();
	}

	public int save(User user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public void delete(int id) {
		sessionFactory.getCurrentSession()
				.createQuery("delete from User where id = :id").setParameter("id", id)
				.executeUpdate();
	}

	public void delete(String name) {
		sessionFactory.getCurrentSession()
				.createQuery("delete from User where name = :name")
				.setParameter("name", name).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public void addFriend(User user, User friend) {
		sessionFactory.getCurrentSession().createQuery("")
				.setParameter("user_id", user.getId())
				.setParameter("friend_id", friend.getId()).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> getFriends(User user) {
		return sessionFactory.getCurrentSession()
				.createQuery("select user.friends from User user where user = :user")
				.setParameter("user", user).list();
	}

	public void clear() {

		sessionFactory.getCurrentSession().createQuery("delete from User")
				.executeUpdate();
	}
}

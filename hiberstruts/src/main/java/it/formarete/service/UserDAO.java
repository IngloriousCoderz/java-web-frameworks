package it.formarete.service;

import it.formarete.model.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {

	public int save(User user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int id = (Integer) session.save(user);
		transaction.commit();
		session.close();

		return id;
	}

	public void update(User user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
	}

	public void delete(User user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
	}

	public User get(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, id);
		transaction.commit();
		session.close();

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<User> users = session.createCriteria(User.class).list();
		transaction.commit();
		session.close();

		return users;
	}
}

package it.formarete.service;

import it.formarete.model.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {
	public int save(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		int id = (Integer) session.save(user);
		transaction.commit();
		session.close();

		return id;
	}

	public void update(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
	}

	public void delete(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
	}

	public User get(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class, id);
		transaction.commit();
		session.close();

		return user;
	}

	public List<User> getAll() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		List<User> users = (List<User>) session.load(User.class, null);
		transaction.commit();
		session.close();

		return users;
	}
}

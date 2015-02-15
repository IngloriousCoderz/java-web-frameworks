package it.formarete.service;

import it.formarete.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {
	public static int save(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		int id = (Integer) session.save(user);
		transaction.commit();
		session.close();

		return id;
	}

	public static void update(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
	}

	public static void delete(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
	}
}

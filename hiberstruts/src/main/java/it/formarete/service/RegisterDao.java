package it.formarete.service;

import it.formarete.model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RegisterDao {
	public static int saveUser(User user) {
		Session session = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		int id = (Integer) session.save(user);
		transaction.commit();
		session.close();

		return id;
	}
}

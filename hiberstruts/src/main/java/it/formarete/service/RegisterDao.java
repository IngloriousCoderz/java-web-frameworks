package it.formarete.service;

import it.formarete.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RegisterDao {
	public static int saveUser(User user) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		int id = (Integer) session.save(user);
		transaction.commit();
		session.close();

		// better call factory.close() when context gets destroyed
		
		return id;
	}
}

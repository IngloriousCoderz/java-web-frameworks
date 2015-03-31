package it.formarete.join.service;

import it.formarete.join.model.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getByUsername(String username) {
		String queryString = "FROM User WHERE username = :username";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("username", username);
		return (User) query.uniqueResult();
	}

	public int save(User user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
}

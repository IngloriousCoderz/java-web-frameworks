package it.formarete.filter;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;

public class HibernateSessionFlushModeFilter extends OpenSessionInViewFilter {
	protected Session getSession(SessionFactory factory)
			throws DataAccessResourceFailureException {
		Session session = factory.getCurrentSession();
		session.setFlushMode(FlushMode.COMMIT);
		return session;
	}

	protected void closeSession(Session session, SessionFactory factory) {
		session.flush();
		factory.close();
	}
}

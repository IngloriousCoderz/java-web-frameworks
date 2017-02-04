package it.formarete.feisbuc.service;

import it.formarete.feisbuc.model.Post;
import it.formarete.feisbuc.model.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PostDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Post get(int id) {
		return (Post) sessionFactory.getCurrentSession().get(Post.class, id);
	}

	public int save(Post post) {
		return (Integer) sessionFactory.getCurrentSession().save(post);
	}

	public void update(Post post) {
		sessionFactory.getCurrentSession().update(post);
	}

	public void delete(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
						"delete from Post where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Post> getAll(User user) {
		return sessionFactory.getCurrentSession()
						.createQuery("from Post where owner = :owner order by id desc")
						.setParameter("owner", user).list();
	}

	public void clear() {
		sessionFactory.getCurrentSession()
						.createQuery("delete from Post")
						.executeUpdate();
	}
}

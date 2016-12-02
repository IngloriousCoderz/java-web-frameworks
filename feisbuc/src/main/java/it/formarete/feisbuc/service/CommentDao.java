package it.formarete.feisbuc.service;

import it.formarete.feisbuc.model.Comment;
import it.formarete.feisbuc.model.Post;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CommentDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Comment get(int id) {
		return (Comment) sessionFactory.getCurrentSession().get(Comment.class, id);
	}

	public int save(Comment comment) {
		return (Integer) sessionFactory.getCurrentSession().save(comment);
	}

	public void update(Comment comment) {
		sessionFactory.getCurrentSession().update(comment);
	}

	public void delete(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
						"delete from Comment where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Comment> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Comment.class)
						.list();
	}

	@SuppressWarnings("unchecked")
	public List<Comment> getAll(Post post) {
		return sessionFactory.getCurrentSession()
						.createQuery("from Comment where post = :post")
						.setParameter("post", post).list();
	}

	public void clear() {
		sessionFactory.getCurrentSession().createQuery("delete from Comment")
						.executeUpdate();
	}
}

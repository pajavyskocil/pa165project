package cz.fi.muni.pa165.dao;

import cz.fi.muni.pa165.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(User user) {
		em.persist(user);
	}

	@Override
	public List<User> getAll() {
		return em.createQuery("select u from User u", User.class)
					   .getResultList();
	}
}

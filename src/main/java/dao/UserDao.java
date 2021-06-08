package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.User;

public class UserDao {
	private EntityManager em;
	
	public UserDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(User user) {
		this.em.persist(user);
	}
	
	public void atualizar(User user) {
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		this.em.merge(user);
		etx.commit();
	}
	
	public void remover(User user) {
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		user = em.merge(user);
		em.createQuery("DELETE FROM User u WHERE u.email = " + "'" + user.getEmail() + "'").executeUpdate();
		etx.commit();
		
	}
	
	public User findById(String email) {
		return em.find(User.class, email);
	}
	
	public List<User> findAll() {
		String jpql = "SELECT u FROM User u";
		return em.createQuery(jpql, User.class).getResultList();
	}
}

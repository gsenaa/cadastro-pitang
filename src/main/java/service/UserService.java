package service;

import java.util.List;

import javax.persistence.EntityManager;

import dao.UserDao;
import model.User;
import util.JPAUtil;

public class UserService {
	public User create(User user) {
		EntityManager em = JPAUtil.getEntityManager();
		UserDao dao = new UserDao(em);
		
		User userExists = dao.findById(user.getEmail());
		
		if(userExists != null) {
			return user;
		}
		
		em.getTransaction().begin();
		dao.cadastrar(user);
		em.getTransaction().commit();
		em.close();
		
		return user;
	}
	
	public User atualizar(User user) {
		EntityManager em = JPAUtil.getEntityManager();
		UserDao dao = new UserDao(em);
		
		dao.atualizar(user);
		
		return user;
	}
	
	public void remove(User user) {
		EntityManager em = JPAUtil.getEntityManager();
		UserDao dao = new UserDao(em);
		em.clear();
		dao.remover(user);
	}

	public User findOne(String email) {
		EntityManager em = JPAUtil.getEntityManager();
		UserDao dao = new UserDao(em);
		
		return dao.findById(email);
	}
	
	public List<User> findAll() {
		EntityManager em = JPAUtil.getEntityManager();
		UserDao dao = new UserDao(em);
		
		return dao.findAll();
	}
}

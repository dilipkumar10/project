package com.capgemini.onlinemovieticketsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinemovieticketsystem.dto.User;
import com.capgemini.onlinemovieticketsystem.exception.OnlineMovieTicketException;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public User registerNewUser(User user) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(user);
			entityTransaction.commit();
		} catch (Exception e) {
			throw new OnlineMovieTicketException("UserId already exists");
		}
		return user;
	}

	@Override
	public User signIn(String userName, String password) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from User where userName=:userName";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		query.setParameter("userName", userName);
		try {
			User user = query.getSingleResult();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(password, user.getPassword())) {
				return user;
			} else
				throw new OnlineMovieTicketException("Password is wrong");
		} catch (Exception e) {
			throw new OnlineMovieTicketException("Wrong credintials");
		}
	}

	@Override
	public boolean signOut() {
		// TODO Auto-generated method stub
		return false;
	}

}

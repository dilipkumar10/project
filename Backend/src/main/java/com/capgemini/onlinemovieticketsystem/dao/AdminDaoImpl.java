package com.capgemini.onlinemovieticketsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinemovieticketsystem.dto.Movie;
import com.capgemini.onlinemovieticketsystem.dto.Screen;
import com.capgemini.onlinemovieticketsystem.dto.Show;
import com.capgemini.onlinemovieticketsystem.dto.Theater;
import com.capgemini.onlinemovieticketsystem.exception.OnlineMovieTicketException;

@Repository
public class AdminDaoImpl implements AdminDao {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Theater addTheater(Theater theater) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(theater);
			entityTransaction.commit();
			entityManager.close();
			return theater;
		} catch (Exception e) {
			throw new OnlineMovieTicketException("TheaterId already exists");
		}
	}

	@Override
	public boolean deleteTheater(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Theater theater = entityManager.find(Theater.class, id);
		if (theater != null) {
			entityTransaction.begin();
			entityManager.remove(theater);
			entityTransaction.commit();
			entityManager.close();
			return true;
		} else {
			throw new OnlineMovieTicketException("Theater id does not exists");
		}
	}

	@Override
	public Movie addMovie(Movie movie) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(movie);
			entityTransaction.commit();
			entityManager.close();
			return movie;
		} catch (Exception e) {
			throw new OnlineMovieTicketException("MovieId already exists");
		}
	}

	@Override
	public boolean deleteMovie(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Movie movie = entityManager.find(Movie.class, id);
		if (movie != null) {
			entityTransaction.begin();
			entityManager.remove(movie);
			entityTransaction.commit();
			entityManager.close();
			return true;
		} else {
			throw new OnlineMovieTicketException("TMovieId does not exists");
		}
	}

	@Override
	public Screen addScreen(Screen screen) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String getScreenId = Integer.toString(screen.getScreenId());
		String getTheaterId = Integer.toString(screen.getTheaterId());
		String concat = getScreenId + getTheaterId;
		int screenId = Integer.parseInt(concat);
		screen.setScreenId(screenId);
		try {
			entityTransaction.begin();
			entityManager.persist(screen);
			entityTransaction.commit();
			entityManager.close();
			return screen;
		} catch (Exception e) {
			throw new OnlineMovieTicketException("ScreenId already exists");
		}
	}

	@Override
	public boolean deleteScreen(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Screen screen = entityManager.find(Screen.class, id);
		if (screen != null) {
			entityTransaction.begin();
			entityManager.remove(screen);
			entityTransaction.commit();
			entityManager.close();
			return true;
		} else {
			throw new OnlineMovieTicketException("ScreenId does not exists");
		}
	}

	@Override
	public Show addShow(Show show) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		String getTheaterId = Integer.toString(show.getTheaterId());
		String getScreenId = Integer.toString(show.getScreenId());
		String getShowId=Integer.toString(show.getShowId());
		String concat =getShowId+ getTheaterId + getScreenId;
		System.out.println(concat);
		int showId = Integer.parseInt(concat);
		System.out.println(showId);
		show.setShowId(showId);
		try {
			entityTransaction.begin();
			entityManager.persist(show);
			entityTransaction.commit();
			entityManager.close();
			return show;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OnlineMovieTicketException("ShowId already exists");
		}
	}

	@Override
	public boolean deleteShow(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Show show = entityManager.find(Show.class, id);
		if (show != null) {
			entityTransaction.begin();
			entityManager.remove(show);
			entityTransaction.commit();
			entityManager.close();
			return true;
		} else {
			throw new OnlineMovieTicketException("ShowId does not exists");
		}
	}

	@Override
	public List<Theater> getAllTheaters() {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Theater";
		Query query = entityManager.createQuery(jpql);
		List<Theater> list = query.getResultList();
		return list;
	}

	@Override
	public boolean updateTheater(Theater theater) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			Theater updateTheater = entityManager.find(Theater.class, theater.getTheaterId());
			if (theater.getTheaterName() != null) {
				updateTheater.setTheaterName(theater.getTheaterName());
			} else {
				updateTheater.setTheaterName(updateTheater.getTheaterName());
			}
			if (theater.getTheaterCity() != null) {
				updateTheater.setTheaterCity(theater.getTheaterCity());
			} else {
				updateTheater.setTheaterCity(updateTheater.getTheaterCity());
			}
			if (theater.getMovies() != null) {
				updateTheater.setMovies(theater.getMovies());
			} else {
				updateTheater.setMovies(updateTheater.getMovies());
			}
			if (theater.getManagerName() != null) {
				updateTheater.setManagerName(theater.getManagerName());
			} else {
				updateTheater.setManagerName(updateTheater.getManagerName());
			}
			if (theater.getManagerContact() != null) {
				updateTheater.setManagerContact(theater.getManagerContact());
			} else {
				updateTheater.setManagerContact(updateTheater.getManagerContact());
			}
			entityTransaction.commit();
		} catch (Exception e) {
			throw new OnlineMovieTicketException("Theater Id does not exists");
		}
		entityManager.close();
		return true;
	}

	@Override
	public Theater getTheater(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Theater theater = entityManager.find(Theater.class, id);
		if (theater != null) {
			return theater;
		} else {
			throw new OnlineMovieTicketException("Theater Id does not exists");
		}
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Movie";
		Query query = entityManager.createQuery(jpql);
		List<Movie> list = query.getResultList();
		return list;
	}

	@Override
	public List<Screen> getAllScreens() {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Screen";
		Query query = entityManager.createQuery(jpql);
		List<Screen> list = query.getResultList();
		return list;
	}

	@Override
	public List<Show> getAllShows() {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Show";
		Query query = entityManager.createQuery(jpql);
		List<Show> list = query.getResultList();
		return list;
	}

}

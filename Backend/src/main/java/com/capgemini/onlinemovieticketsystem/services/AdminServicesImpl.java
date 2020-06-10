package com.capgemini.onlinemovieticketsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinemovieticketsystem.dao.AdminDao;
import com.capgemini.onlinemovieticketsystem.dto.Movie;
import com.capgemini.onlinemovieticketsystem.dto.Screen;
import com.capgemini.onlinemovieticketsystem.dto.Show;
import com.capgemini.onlinemovieticketsystem.dto.Theater;
import com.capgemini.onlinemovieticketsystem.exception.OnlineMovieTicketException;

@Service
public class AdminServicesImpl implements AdminServices {
	@Autowired
	private AdminDao adminDao;

	@Override
	public Theater addTheater(Theater theater) {
		// TODO Auto-generated method stub
		return adminDao.addTheater(theater);
	}

	@Override
	public boolean deleteTheater(int id) {
		// TODO Auto-generated method stub
		return adminDao.deleteTheater(id);
	}

	@Override
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		List<Theater> theater = adminDao.getAllTheaters();
		for (Theater theater2 : theater) {
			if (theater2.getTheaterId() == movie.getTheaterId()) {
				return adminDao.addMovie(movie);
			}
		}
		throw new OnlineMovieTicketException("Unable to add movie as Theater Id does not exist");
	}

	@Override
	public boolean deleteMovie(int id) {
		// TODO Auto-generated method stub
		return adminDao.deleteMovie(id);
	}

	@Override
	public Screen addScreen(Screen screen) {
		// TODO Auto-generated method stub
		List<Theater> theater = adminDao.getAllTheaters();
		for (Theater theater2 : theater) {
			if (theater2.getTheaterId() == screen.getTheaterId()) {
				return adminDao.addScreen(screen);
			}
		}
		throw new OnlineMovieTicketException("Unable to add screen as Theater Id does not exist");
	}

	@Override
	public boolean deleteScreen(int id) {
		// TODO Auto-generated method stub
		return adminDao.deleteScreen(id);
	}

	@Override
	public Show addShow(Show show) {
		// TODO Auto-generated method stub
		List<Theater> list = adminDao.getAllTheaters();
		List<Screen> list1 = adminDao.getAllScreens();
		for (Screen screen : list1) {
			for (Theater theater : list) {
				if (screen.getScreenId() == show.getScreenId()) {
					if (theater.getTheaterId() == show.getTheaterId()) {
						return adminDao.addShow(show);
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean deleteShow(int id) {
		// TODO Auto-generated method stub
		return adminDao.deleteShow(id);
	}

	@Override
	public List<Theater> getAllTheaters() {
		// TODO Auto-generated method stub
		return adminDao.getAllTheaters();
	}

	@Override
	public boolean updateTheater(Theater theater) {
		// TODO Auto-generated method stub
		return adminDao.updateTheater(theater);
	}

	@Override
	public Theater getTheater(int id) {
		// TODO Auto-generated method stub
		return adminDao.getTheater(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return adminDao.getAllMovies();
	}

	@Override
	public List<Screen> getAllScreens() {
		// TODO Auto-generated method stub
		return adminDao.getAllScreens();
	}

	@Override
	public List<Show> getAllShows() {
		// TODO Auto-generated method stub
		return adminDao.getAllShows();
	}

}

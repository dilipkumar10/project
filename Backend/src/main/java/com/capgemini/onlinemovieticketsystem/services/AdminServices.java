package com.capgemini.onlinemovieticketsystem.services;

import java.util.List;

import com.capgemini.onlinemovieticketsystem.dto.Movie;
import com.capgemini.onlinemovieticketsystem.dto.Screen;
import com.capgemini.onlinemovieticketsystem.dto.Show;
import com.capgemini.onlinemovieticketsystem.dto.Theater;

public interface AdminServices {
	public Theater addTheater(Theater theater);

	public boolean deleteTheater(int id);

	public Movie addMovie(Movie movie);

	public boolean deleteMovie(int id);

	public Screen addScreen(Screen screen);

	public boolean deleteScreen(int id);

	public Show addShow(Show show);

	public boolean deleteShow(int id);

	public List<Theater> getAllTheaters();

	public boolean updateTheater(Theater theater);

	public Theater getTheater(int id);

	public List<Movie> getAllMovies();

	public List<Screen> getAllScreens();

	public List<Show> getAllShows();
}
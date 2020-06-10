package com.capgemini.onlinemovieticketsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinemovieticketsystem.dto.Admin;
import com.capgemini.onlinemovieticketsystem.dto.Movie;
import com.capgemini.onlinemovieticketsystem.dto.OnlineMovieTicketResponse;
import com.capgemini.onlinemovieticketsystem.dto.Screen;
import com.capgemini.onlinemovieticketsystem.dto.Show;
import com.capgemini.onlinemovieticketsystem.dto.Theater;
import com.capgemini.onlinemovieticketsystem.services.AdminServices;

@CrossOrigin
@RestController
public class AdminController {
	@Autowired
	private AdminServices adminServices;

	@PostMapping(path = "/add-theater", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse addTheater(@RequestBody Theater theater) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		if (adminServices.addTheater(theater) != null) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Theater added successfully");
			onlineMovieTicketResponse.setBeans(Arrays.asList(theater));
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Theater not added");
		}
		return onlineMovieTicketResponse;
	}

	@DeleteMapping(path = "/delete-theater/{theaterId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse deleteTheater(@PathVariable("theaterId") int theaterId) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		if (adminServices.deleteTheater(theaterId)) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Theater deleted successfully");
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Theater not added");
		}
		return onlineMovieTicketResponse;
	}

	@PostMapping(path = "/add-movie", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse addMovie(@RequestBody Movie movie) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		if (adminServices.addMovie(movie) != null) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Movie added successfully");
			onlineMovieTicketResponse.setBeans(Arrays.asList(movie));
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Movie not added");
		}
		return onlineMovieTicketResponse;
	}

	@DeleteMapping(path = "/delete-movie/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse deleteMovie(@PathVariable("movieId") int movieId) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		if (adminServices.deleteMovie(movieId)) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Movie deleted successfully");
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Movie not added");
		}
		return onlineMovieTicketResponse;
	}

	@PostMapping(path = "/add-screen", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse addScreen(@RequestBody Screen screen) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		if (adminServices.addScreen(screen) != null) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Screen added successfully");
			onlineMovieTicketResponse.setBeans(Arrays.asList(screen));
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Screen not added");
		}
		return onlineMovieTicketResponse;
	}

	@DeleteMapping(path = "/delete-screen/{screenId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse deleteScreen(@PathVariable("screenId") int screenId) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		if (adminServices.deleteScreen(screenId)) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Screen deleted successfully");
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Screen not added");
		}
		return onlineMovieTicketResponse;
	}

	@PostMapping(path = "/add-show", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse addShow(@RequestBody Show show) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		if (adminServices.addShow(show) != null) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Show added successfully");
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Theater ID or screen Id des not exist");
		}
		return onlineMovieTicketResponse;
	}

	@DeleteMapping(path = "/delete-show/{showId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse deleteShow(@PathVariable("showId") int showId) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		if (adminServices.deleteShow(showId)) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Show deleted successfully");
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Show not added");
		}
		return onlineMovieTicketResponse;
	}

	@GetMapping(path = "/get-theater/{theaterId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse getTheater(@PathVariable("theaterId") int theaterId) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		Theater theater = adminServices.getTheater(theaterId);
		if (theater != null) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Theater found successfully");
			onlineMovieTicketResponse.setBeans(Arrays.asList(theater));
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Theater Id does not exists");
		}
		return onlineMovieTicketResponse;
	}

	@GetMapping(path = "/get-all-theaters", produces = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse getAllTheaters() {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		List<Theater> list = adminServices.getAllTheaters();
		System.out.println(list);
		if (list != null && !list.isEmpty()) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Theaters found successfully");
			onlineMovieTicketResponse.setBeans(list);
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Theaters  does not exists");
		}
		return onlineMovieTicketResponse;
	}

	@GetMapping(path = "/get-all-movies", produces = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse getAllMovies() {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		List<Movie> list = adminServices.getAllMovies();
		if (list != null && !list.isEmpty()) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Movies found successfully");
			onlineMovieTicketResponse.setBeans(list);
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Movies  does not exists");
		}
		return onlineMovieTicketResponse;
	}

	@GetMapping(path = "/get-all-screens", produces = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse getAllScreens() {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		List<Screen> list = adminServices.getAllScreens();
		if (list != null && !list.isEmpty()) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Screens found successfully");
			onlineMovieTicketResponse.setBeans(list);
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Screens  does not exists");
		}
		return onlineMovieTicketResponse;
	}

	@GetMapping(path = "/get-all-shows", produces = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse getAllShows() {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		List<Show> list = adminServices.getAllShows();
		if (list != null && !list.isEmpty()) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Shows found successfully");
			onlineMovieTicketResponse.setBeans(list);
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Shows  does not exists");
		}
		return onlineMovieTicketResponse;
	}

	@PutMapping(path = "update-theater", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse updateTheater(@RequestBody Theater theater) {
		OnlineMovieTicketResponse onlineMovieTicketResponse = new OnlineMovieTicketResponse();
		if (adminServices.updateTheater(theater)) {
			onlineMovieTicketResponse.setStatusCode(200);
			onlineMovieTicketResponse.setMessage("Success");
			onlineMovieTicketResponse.setDescription("Theater modified");
		} else {
			onlineMovieTicketResponse.setStatusCode(401);
			onlineMovieTicketResponse.setMessage("failure");
			onlineMovieTicketResponse.setDescription("Theater Id does not exists");
		}
		return onlineMovieTicketResponse;
	}
}

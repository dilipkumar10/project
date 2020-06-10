package com.capgemini.onlinemovieticketsystem.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinemovieticketsystem.dto.OnlineMovieTicketResponse;
import com.capgemini.onlinemovieticketsystem.dto.User;
import com.capgemini.onlinemovieticketsystem.services.UserServices;
@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserServices userServices;

	@PostMapping(path = "/register-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse registerUser(@RequestBody User user) {
		OnlineMovieTicketResponse response = new OnlineMovieTicketResponse();
		User userInfo = userServices.registerNewUser(user);
		if (userInfo != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User registered");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("User already exists");
		}
		return response;
	}

	@PostMapping(path = "/login-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OnlineMovieTicketResponse loginUser(@RequestBody User user) {
		OnlineMovieTicketResponse response = new OnlineMovieTicketResponse();
		User userInfo = userServices.signIn(user.getUserName(), user.getPassword());
		if (userInfo != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Successfully logged in");
			response.setBeans(Arrays.asList(userInfo));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Credintials are invalid");
		}
		return response;
	}
}

package com.capgemini.onlinemovieticketsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.onlinemovieticketsystem.dto.OnlineMovieTicketResponse;
import com.capgemini.onlinemovieticketsystem.exception.OnlineMovieTicketException;

@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(OnlineMovieTicketException.class)
	public OnlineMovieTicketResponse handleCustomException(OnlineMovieTicketException e) {
		OnlineMovieTicketResponse response = new OnlineMovieTicketResponse();
		response.setStatusCode(501);
		response.setDescription(e.getMessage());
		response.setMessage("Exception");
		return response;
	}
}

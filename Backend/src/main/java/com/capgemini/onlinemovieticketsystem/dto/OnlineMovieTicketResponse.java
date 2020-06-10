package com.capgemini.onlinemovieticketsystem.dto;

import java.util.List;

import lombok.Data;
@Data
public class OnlineMovieTicketResponse {
	private int statusCode;
	private String message;
	private String description;
	private List beans;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List getBeans() {
		return beans;
	}
	public void setBeans(List beans) {
		this.beans = beans;
	}
	
}

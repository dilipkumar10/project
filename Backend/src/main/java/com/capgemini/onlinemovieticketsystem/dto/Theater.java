package com.capgemini.onlinemovieticketsystem.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Theater {
	@Id
	@Column
	private int theaterId;
	@Column
	private String theaterName;
	@Column
	private String theaterCity;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="moviees")
	private List<Movie> movies;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="screens")
	private List<Screen> listOfScreens;
	@Column
	private String managerName;
	@Column
	private String managerContact;
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
//	public List<Screen> getListOfScreens() {
//		return listOfScreens;
//	}
//	public void setListOfScreens(List<Screen> listOfScreens) {
//		this.listOfScreens = listOfScreens;
//	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	

}

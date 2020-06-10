package com.capgemini.onlinemovieticketsystem.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode.Include;

@Entity
@Table
public class Movie {
	@Id
	@Column
	private int movieId;
	@Column
	private String movieName;
	@Column
	private int theaterId;
	@Column
	private String movieDirector;
	@Column
	private int movieLength; 
	@Column
	private LocalDate movieReleaseDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "theater")
	private Theater moviees;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public Theater getMoviees() {
		return moviees;
	}

	public void setMoviees(Theater moviees) {
		this.moviees = moviees;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

//	public Movie getMoviees() {
//		return moviees;
//	}
//
//	public void setMoviees(Movie moviees) {
//		this.moviees = moviees;
//	}
	

}

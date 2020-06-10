package com.capgemini.onlinemovieticketsystem.dto;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Showes")
public class Show {
	@Id
	@Column
	private int showId;
	@Column
	private Time showStartTime;
	@Column
	private Time showEndTime;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "seaters")
	private List<Seat> seats;
	@Column
	private String showName;
	@Column
	private String movieName;
	@Column
	private int theaterId;
	@Column
	private int screenId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "screeners")
	private Screen shows;
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public Time getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(Time showStartTime) {
		this.showStartTime = showStartTime;
	}
	public Time getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(Time showEndTime) {
		this.showEndTime = showEndTime;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
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
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public Screen getShows() {
		return shows;
	}
	public void setShows(Screen shows) {
		this.shows = shows;
	}
	
	
}

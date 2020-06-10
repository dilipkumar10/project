package com.capgemini.onlinemovieticketsystem.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Seat {
	@Id
	@Column
	private int seatId;

	private enum seatStatus {
		Booked, Book
	};
	@Column
	private double seatPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "showsId")
	private Show seaters;
	
}

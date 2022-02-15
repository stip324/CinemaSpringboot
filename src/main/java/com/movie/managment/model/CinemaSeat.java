package com.movie.managment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cinemaSeat")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CinemaSeat {
	@Id
	private String cinemaSeatId;
	private boolean premium;
	
	@ManyToOne
	private CinemaHall cinemaHall;
	public CinemaSeat() {
		// TODO Auto-generated constructor stub
	}
	public CinemaSeat(CinemaHall cinemaHall) {
		super();
		this.cinemaHall = cinemaHall;
	}

}
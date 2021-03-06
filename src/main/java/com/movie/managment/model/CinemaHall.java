package com.movie.managment.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cinemaHall")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CinemaHall {
	@Id
	private String HallId;
	
	@OneToMany
	//@JoinColumn(name="cinema_seat_Id")
	private Set<CinemaSeat> cinemaSeat;
	
	@ManyToOne
	//@JoinColumn(name="cinema_Id")
	private Cinema cinema;
	public CinemaHall() {
		// TODO Auto-generated constructor stub
	}

}

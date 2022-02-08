package com.movie.managment.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cinema")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cinema {
	@Id
	private String cinemaId;
	private String cinemaName;
	@OneToMany(mappedBy="cinema")
	private Set<CinemaHall> cinemaHalls;
	
	

	public Cinema(String cinemaId, String cinemaName, Set<CinemaHall> cinemaHalls) {
		super();
		this.cinemaId = cinemaId;
		this.cinemaName = cinemaName;
		this.cinemaHalls = cinemaHalls;
	}

}

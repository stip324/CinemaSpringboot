package com.movie.managment.model.show;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.movie.managment.model.CinemaHall;
import com.movie.managment.model.Genres;
import com.movie.managment.model.movie.Movie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "show")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Show {
	@Id
	private String showID;
	private Date showDate;
	private Time startTime;
	private Time endTime;
	
	@OneToOne
	private Movie movie;
	
	//private CinemaHall cinemaHall;
	
	
	
	public Show() {
		// TODO Auto-generated constructor stub
	}

}

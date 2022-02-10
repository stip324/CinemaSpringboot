package com.movie.managment.model.show;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
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
	private String showId;
	@JsonFormat(pattern = "yyyy-MM-dd", shape =Shape.STRING)
	private Date showDate;
	//@Temporal(TemporalType.TIME)
	//@DateTimeFormat(style = "HH:mm")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime  startTime;
	//@Temporal(TemporalType.TIME)
	//@DateTimeFormat(style = "HH:mm")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime  endTime;
	private int price;
	
	@OneToOne
	private Movie movie;
	
	//private CinemaHall cinemaHall;
	
	
	
	public Show() {
		// TODO Auto-generated constructor stub
	}

}

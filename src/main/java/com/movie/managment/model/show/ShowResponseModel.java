package com.movie.managment.model.show;

import java.sql.Time;
import java.util.Date;

import com.movie.managment.model.movie.Movie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShowResponseModel {
	private String showId;
	private Date showDate;
	private Time startTime;
	private Time endTime;
	private Movie movie;
	
	public ShowResponseModel() {}
	public ShowResponseModel(String showId, Date showDate, Time startTime, Time endTime, Movie movie) {
		super();
		this.showId = showId;
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movie = movie;
	}
}

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
public class ShowRequestModel {
	
	private String showID;
	private Date showDate;
	private Time startTime;
	private Time endTime;
	private Movie movie;
	
	public ShowRequestModel(String showID, Date showDate, Time startTime, Time endTime, Movie movie) {
		super();
		this.showID = showID;
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movie = movie;
	}
	
}

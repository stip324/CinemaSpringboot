 package com.movie.managment.model.show;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.movie.managment.model.movie.Movie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShowResponseModel {
	private String showId;
	@JsonFormat(pattern = "yyyy-MM-dd", shape =Shape.STRING)
	private Date showDate;
	private LocalTime  startTime;
	private LocalTime  endTime;
	private Movie movie;
	private int price;
	
	public ShowResponseModel() {}
	public ShowResponseModel(String showId, Date showDate, LocalTime  startTime, LocalTime  endTime,int price, Movie movie) {
		super();
		this.showId = showId;
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.movie = movie;
	}
}

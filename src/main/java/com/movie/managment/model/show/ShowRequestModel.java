package com.movie.managment.model.show;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.movie.managment.model.movie.Movie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShowRequestModel {
	
	private String showID;
	@JsonFormat(pattern = "yyyy-MM-dd", shape =Shape.STRING)
	private Date showDate;
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime  startTime;
	//@Temporal(TemporalType.TIME)
	//@DateTimeFormat(style = "HH:mm")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime  endTime;
	private int price;
	private Movie movie;
	
	public ShowRequestModel(String showID, Date showDate, LocalTime  startTime, LocalTime  endTime,int price, Movie movie) {
		super();
		this.showID = showID;
		this.showDate = showDate;
		this.startTime = startTime;
		this.price = price;
		this.endTime = endTime;
		this.movie = movie;
	}
	
}

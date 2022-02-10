package com.movie.managment.model.movie;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MovieRequestModel {
	private String movieId;
	private String movieName;
	private String description;
	private String[] starring;
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime runTime;
	private String slug;
	private int genresId;



	public MovieRequestModel(String movieId, String movieName, String description, String[] starring, LocalTime runTime,
			String slug) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
		this.starring = starring;
		this.runTime = runTime;
		this.slug = slug;
	}



	public MovieRequestModel() {
		
	}
}

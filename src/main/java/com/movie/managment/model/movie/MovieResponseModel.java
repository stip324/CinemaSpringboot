package com.movie.managment.model.movie;

import java.time.LocalTime;

import lombok.*;

@Getter
@Setter
@ToString
public class MovieResponseModel {
	private String movieId;
	private String movieName;
	private String description;
	private String[] starring;
	private LocalTime runTime;
	private String slug;



	public MovieResponseModel() {
		
	}



	public MovieResponseModel(String movieId, String movieName, String description, String[] starring, LocalTime runTime,
			String slug) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
		this.starring = starring;
		this.runTime = runTime;
		this.slug = slug;
	}

}

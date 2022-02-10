package com.movie.managment.model.movie;

import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movie.managment.model.Genres;
import com.movie.managment.model.MovieCast;
import com.movie.managment.model.show.Show;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "movie")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Movie {
	@Id
	private String movieId;
	private String movieName;
	private String description;
	//change to moviecast?
	private String[] starring;
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime runTime;
	private String slug;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "genres_id")
	private Genres genres;
	
	
	@OneToOne(mappedBy="movie")
	private MovieCast movieCast;
	
	public Movie() {
		
	}

	public Movie(String movieId, String movieName, String description, String[] starring, LocalTime runTime, String slug) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
		this.starring = starring;
		this.runTime = runTime;
		this.slug = slug;
	}

}

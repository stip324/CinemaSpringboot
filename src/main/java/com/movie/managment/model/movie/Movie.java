package com.movie.managment.model.movie;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private String[] starring;
	private int runTime;
	private String slug;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "genres_id")
	private Genres genres;
	
	@OneToOne(mappedBy="movie")
	private Show show;
	
	@OneToOne(mappedBy="movie")
	private MovieCast movieCast;
	
	public Movie() {
		
	}

	public Movie(String movieId, String movieName, String description, String[] starring, int runTime, String slug) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
		this.starring = starring;
		this.runTime = runTime;
		this.slug = slug;
	}

}

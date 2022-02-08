package com.movie.managment.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.movie.managment.model.movie.Movie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "movie_cast")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MovieCast {
	@Id
	private String castId;
	
	@ManyToMany
	private Set<Actor> actors;
	
	@ManyToMany
	private Set<Director> directors;
	
	@OneToOne
	private Movie movie;
	
	
	
	public MovieCast() {
		// TODO Auto-generated constructor stub
	}

}

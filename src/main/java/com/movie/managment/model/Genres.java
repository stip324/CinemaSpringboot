package com.movie.managment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.movie.managment.model.movie.Movie;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "genres")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Genres {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String genresId;
	private String genres;
	@OneToOne(mappedBy="genres")
	private Movie movie;
	public Genres(String genresId, String genres) {
		super();
		this.genresId = genresId;
		this.genres = genres;
	}
	

}

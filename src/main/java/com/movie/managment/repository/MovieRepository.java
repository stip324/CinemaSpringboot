package com.movie.managment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.managment.model.Genres;
import com.movie.managment.model.movie.Movie;


public interface MovieRepository  extends JpaRepository<Movie,String> {
	List<Movie> findByGenres(Genres g);
	List<Movie> findByMovieName(String name);


}

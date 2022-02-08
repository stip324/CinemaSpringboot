package com.movie.managment.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.managment.model.Genres;

public interface GenresRepository extends CrudRepository<Genres, String> {

}

package com.movie.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.managment.model.show.Show;





public interface ShowRepository extends JpaRepository<Show,String> {

}

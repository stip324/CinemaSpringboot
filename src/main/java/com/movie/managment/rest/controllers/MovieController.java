package com.movie.managment.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.managment.model.movie.MovieRequestModel;
import com.movie.managment.model.movie.MovieResponseModel;
import com.movie.managment.repository.MovieRepository;
import com.movie.managment.services.MovieServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieController {
	@Autowired
	MovieServiceImpl movieService;

	@PostMapping(value = "/movies", produces = "application/json")
	public ResponseEntity<MovieResponseModel> addMovie(@RequestBody MovieRequestModel requestModel) {
		MovieResponseModel returnObject = movieService.createCustomer(requestModel);
		
		return new ResponseEntity<MovieResponseModel>(returnObject, HttpStatus.CREATED);
	}


	@GetMapping(value = "/movies", produces = "application/json")
	public ResponseEntity<List<MovieResponseModel>> getAllMovies() {
		List<MovieResponseModel> returnList =   movieService.getAllMovies();
  		return new ResponseEntity<List<MovieResponseModel>>(returnList, HttpStatus.OK);
	}

	@RequestMapping(value = "/movies/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MovieResponseModel> getMovieById(@PathVariable("id") String id) {

		MovieResponseModel object =   movieService.getMovieById(id);
        if(object != null) {
        	return new ResponseEntity<MovieResponseModel>(object, HttpStatus.OK);
        }
		return new ResponseEntity<MovieResponseModel>(HttpStatus.NO_CONTENT);

	}

	// Object with data is sent, id
	// if id exists, then update the resource
	// PUT
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.PUT, produces = "application/JSON", consumes = "application/JSON")
	public ResponseEntity<MovieResponseModel> updateMovie(@PathVariable("id") String id,
			@RequestBody MovieRequestModel requestModel) {
		
		MovieResponseModel responseObject =   movieService.updateCustomer(id, requestModel);
		if(responseObject != null) {
			new ResponseEntity<MovieResponseModel>(responseObject, HttpStatus.OK);
		}
		
		return new ResponseEntity<MovieResponseModel>(HttpStatus.NOT_FOUND);

	}

	// accept id from client, delete corresponding resource from server
	// DELETE
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
	public void deleteTutorial(@PathVariable("id") String id) {
		movieService.deleteMovie(id);
	}


}

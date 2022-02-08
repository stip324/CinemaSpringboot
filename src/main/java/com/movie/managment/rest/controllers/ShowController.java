package com.movie.managment.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movie.managment.model.show.ShowRequestModel;
import com.movie.managment.model.show.ShowResponseModel;
import com.movie.managment.services.ShowServiceImpl;

@Service
public class ShowController {

	@Autowired
	ShowServiceImpl showService;

	@PostMapping(value = "/show", produces = "application/json")
	public ResponseEntity<ShowResponseModel> addBooking(@RequestBody ShowRequestModel requestModel) {
		ShowResponseModel returnObject = showService.createShow(requestModel);
		
		return new ResponseEntity<ShowResponseModel>(returnObject, HttpStatus.CREATED);
	}


	@GetMapping(value = "/show", produces = "application/json")
	public ResponseEntity<List<ShowResponseModel>> getAllBooking() {
		List<ShowResponseModel> returnList =   showService.getAllShows();
  		return new ResponseEntity<List<ShowResponseModel>>(returnList, HttpStatus.OK);
	}

	@RequestMapping(value = "/show/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ShowResponseModel> getMovieById(@PathVariable("id") String id) {

		ShowResponseModel object =  showService.getShowById(id);
        if(object != null) {
        	return new ResponseEntity<ShowResponseModel>(object, HttpStatus.OK);
        }
		return new ResponseEntity<ShowResponseModel>(HttpStatus.NO_CONTENT);

	}

	// Object with data is sent, id
	// if id exists, then update the resource
	// PUT
	@RequestMapping(value = "/show/{id}", method = RequestMethod.PUT, produces = "application/JSON", consumes = "application/JSON")
	public ResponseEntity<ShowResponseModel> updateMovie(@PathVariable("id") String id,
			@RequestBody ShowRequestModel requestModel) {
		
		ShowResponseModel responseObject =   showService.updateShow(id, requestModel);
		if(responseObject != null) {
			new ResponseEntity<ShowResponseModel>(responseObject, HttpStatus.OK);
		}
		
		return new ResponseEntity<ShowResponseModel>(HttpStatus.NOT_FOUND);

	}

	// accept id from client, delete corresponding resource from server
	// DELETE
	@RequestMapping(value = "/show/{id}", method = RequestMethod.DELETE)
	public void deleteTutorial(@PathVariable("id") String id) {
		showService.deleteShow(id);
	}

}

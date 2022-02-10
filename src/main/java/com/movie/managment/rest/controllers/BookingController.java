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

import com.movie.managment.model.booking.BookingRequestModel;
import com.movie.managment.model.booking.BookingResponseModel;
import com.movie.managment.services.BookingServiceImpl;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingService;

	@PostMapping(value = "/booking", produces = "application/json")
	public ResponseEntity<BookingResponseModel> addBooking(@RequestBody BookingRequestModel requestModel) {
		BookingResponseModel returnObject = bookingService.createBooking(requestModel);
		
		return new ResponseEntity<BookingResponseModel>(returnObject, HttpStatus.CREATED);
	}


	@GetMapping(value = "/boooking", produces = "application/json")
	public ResponseEntity<List<BookingResponseModel>> getAllBooking() {
		List<BookingResponseModel> returnList =   bookingService.getAllBooking();
  		return new ResponseEntity<List<BookingResponseModel>>(returnList, HttpStatus.OK);
	}

	@RequestMapping(value = "/booking/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<BookingResponseModel> getBookingById(@PathVariable("id") String id) {

		BookingResponseModel object =   bookingService.getBookingById(id);
        if(object != null) {
        	return new ResponseEntity<BookingResponseModel>(object, HttpStatus.OK);
        }
		return new ResponseEntity<BookingResponseModel>(HttpStatus.NO_CONTENT);

	}

	// Object with data is sent, id
	// if id exists, then update the resource
	// PUT
	@RequestMapping(value = "/booking/{id}", method = RequestMethod.PUT, produces = "application/JSON", consumes = "application/JSON")
	public ResponseEntity<BookingResponseModel> updateBooking(@PathVariable("id") String id,
			@RequestBody BookingRequestModel requestModel) {
		
		BookingResponseModel responseObject =   bookingService.updateBooking(id, requestModel);
		if(responseObject != null) {
			new ResponseEntity<BookingResponseModel>(responseObject, HttpStatus.OK);
		}
		
		return new ResponseEntity<BookingResponseModel>(HttpStatus.NOT_FOUND);

	}

	// accept id from client, delete corresponding resource from server
	// DELETE
	@RequestMapping(value = "/booking/{id}", method = RequestMethod.DELETE)
	public void deleteBooking(@PathVariable("id") String id) {
		bookingService.deleteBooking(id);
	}

}

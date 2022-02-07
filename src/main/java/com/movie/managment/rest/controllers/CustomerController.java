package com.movie.managment.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.managment.model.customer.CustomerRequestModel;
import com.movie.managment.model.customer.CustomerResponseModel;
import com.movie.managment.services.CustomerServiceImpl;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;


	@PostMapping(value = "/users", produces = "application/json")
	public ResponseEntity<CustomerResponseModel> addUser(@RequestBody CustomerRequestModel requestModel) {
		CustomerResponseModel returnObject = customerService.createCustomer(requestModel);
		
		return new ResponseEntity<CustomerResponseModel>(returnObject, HttpStatus.CREATED);
	}


	@GetMapping(value = "/users", produces = "application/json")
	public ResponseEntity<List<CustomerResponseModel>> getAllUsers() {
		List<CustomerResponseModel> returnList =   customerService.getAllCustomer();
  		return new ResponseEntity<List<CustomerResponseModel>>(returnList, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CustomerResponseModel> getUserById(@PathVariable("id") String id) {

		CustomerResponseModel object =   customerService.getCustomerById(id);
        if(object != null) {
        	return new ResponseEntity<CustomerResponseModel>(object, HttpStatus.OK);
        }
		return new ResponseEntity<CustomerResponseModel>(HttpStatus.NO_CONTENT);

	}

	// Object with data is sent, id
	// if id exists, then update the resource
	// PUT
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = "application/JSON", consumes = "application/JSON")
	public ResponseEntity<CustomerResponseModel> updateUser(@PathVariable("id") String id,
			@RequestBody CustomerRequestModel requestModel) {
		
		CustomerResponseModel responseObject =   customerService.updateCustomer(id, requestModel);
		if(responseObject != null) {
			new ResponseEntity<CustomerResponseModel>(responseObject, HttpStatus.OK);
		}
		
		return new ResponseEntity<CustomerResponseModel>(HttpStatus.NOT_FOUND);

	}

	// accept id from client, delete corresponding resource from server
	// DELETE
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteTutorial(@PathVariable("id") String id) {
		customerService.deleteTutorial(id);
	}

	
	// return list of all tutorial where published is true

	// return list of all tutorial containing the same title
	/*@GetMapping(value = "/title/tutorials", produces = "application/json")
	public ResponseEntity<List<CustomerResponseModel>> getAllTutorialBasedOnTitle(@RequestParam("title") String title) {
		 
		   List<CustomerResponseModel> returnList =    customerService.getAllTutorialBasedOnTitle(title);

		if (returnList.isEmpty())
			return new ResponseEntity<List<CustomerResponseModel>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<CustomerResponseModel>>(returnList, HttpStatus.OK);
	}*/

}

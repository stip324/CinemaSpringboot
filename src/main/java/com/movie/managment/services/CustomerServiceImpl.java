package com.movie.managment.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.managment.model.customer.*;
import com.movie.managment.repository.CustomerRepository;






@Service
public class CustomerServiceImpl {
	@Autowired
	CustomerRepository customerRepository;

	public CustomerResponseModel createCustomer(CustomerRequestModel request) {
		Customer c = new Customer();
		c.setCustomerId(UUID.randomUUID().toString());
		c.setFirstName(request.getFirstName());
		c.setLastName(request.getLastName());
		c.setEmail(request.getEmail());
		c.setPassword(request.getPassword());
		customerRepository.save(c);
		CustomerResponseModel response =new CustomerResponseModel();
		response.setCustomerId(c.getCustomerId());
		response.setFirstName(c.getFirstName());
		response.setLastName(c.getLastName());
		response.setEmail(c.getEmail());
		response.setPassword(c.getPassword());

		return response;

	}

	public List<CustomerResponseModel> getAllCustomer() {
		ModelMapper mapper = new ModelMapper();
		List<CustomerResponseModel> returnList = new ArrayList<CustomerResponseModel>();

		List<Customer> list = customerRepository.findAll();

		for (Customer c : list) {
			CustomerResponseModel modelObject = mapper.map(c, CustomerResponseModel.class);
			returnList.add(modelObject);
		}

		return returnList;
	}
	
	public CustomerResponseModel getCustomerById(String Id) {
		Optional<Customer> optional = customerRepository.findById(Id);

		if (optional.isPresent()) {
			Customer c = optional.get();
			ModelMapper mapper = new ModelMapper();
			CustomerResponseModel returnObject = mapper.map(c, CustomerResponseModel.class);
			return returnObject;
		}

		return null;
		
	}
	
	public CustomerResponseModel updateCustomer(String id, CustomerRequestModel requestModel) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			ModelMapper mapper = new ModelMapper();
			Customer c = mapper.map(requestModel, Customer.class);
			c.setCustomerId(id);
			customerRepository.save(c);
			CustomerResponseModel trm = mapper.map(c, CustomerResponseModel.class);
			return trm;
		}

		return null;

	}

	public void deleteTutorial(String id) {
		customerRepository.deleteById(id);
	}

	/*public Customer getCustomerByEmail(String email) {
		return null;
	}
	
	public Customer getCustomerByFirstName(String firstname) {
		return null;
	}
	
	public Customer getCustomerByLastName(String lastname) {
		return null;
	}*/
	
	
}

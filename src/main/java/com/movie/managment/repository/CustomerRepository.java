package com.movie.managment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.managment.model.customer.Customer;


public interface CustomerRepository extends JpaRepository<Customer,String> {
	List<Customer> findByEmail(String email);
	List<Customer> findByfirstName(String firstname);
	List<Customer> findBylastName(String lastName);
}

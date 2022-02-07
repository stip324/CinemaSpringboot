package com.movie.managment.model.customer;

import lombok.*;

@Getter
@Setter
@ToString
public class CustomerResponseModel {
	private String customerId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;

	public CustomerResponseModel(String customerId, String firstName, String lastName, String password, String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	public CustomerResponseModel() {
		
	}

}

package com.movie.managment.model.customer;

import lombok.*;

@Getter
@Setter
public class CustomerRequestModel {
	private String firstName;
	private String lastName;
	private String password;
	private String email;

	public CustomerRequestModel(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

}

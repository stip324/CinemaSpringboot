package com.movie.managment.model.customer;

import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String customerId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	public Customer() {}
	public Customer(String customerId, String firstName, String lastName, String password, String email) {
		super();
		this.customerId = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	

}

package com.movie.managment.model;


import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "directors")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Director {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String directorId;
	private String firstName;
	private String lastName;
	
	
	@ManyToMany
	private Set<MovieCast> movieCast;
	

	public Director(String actorId, String firstName, String lastName) {
		super();
		this.directorId = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
	}

}

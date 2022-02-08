package com.movie.managment.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "actors")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Actor {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String actorId;
	private String firstName;
	private String lastName;
	
	@ManyToMany
	private Set<Actor> actors;

	public Actor(String actorId, String firstName, String lastName) {
		super();
		this.actorId = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
	}

}

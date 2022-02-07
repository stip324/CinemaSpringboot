package com.movie.managment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "genres")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cinemaId;
	private String cinemaName;
	private int totalCinemahalls;

	public Cinema(String cinemaId, String cinemaName, int totalCinemahalls) {
		super();
		this.cinemaId = cinemaId;
		this.cinemaName = cinemaName;
		this.totalCinemahalls = totalCinemahalls;
	}

}

package com.movie.managment.model.booking;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Booking {
	@Id
	private String bookingId;
	
	private String movieName;
	
	private String numberOfTickets;
	
	private String date;
	
	private String time;
	
	private String customerEmail;
	
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}



	public Booking(String bookingId, String movieName, String numberOfTickets, String date, String time,
			String customerEmail) {
		super();
		this.bookingId = bookingId;
		this.movieName = movieName;
		this.numberOfTickets = numberOfTickets;
		this.date = date;
		this.time = time;
		this.customerEmail = customerEmail;
	}

	

}

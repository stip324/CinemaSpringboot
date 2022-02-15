package com.movie.managment.model.booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseModel {
private String bookingId;
	
	private String movieName;
	
	private String numberOfTickets;
	
	private String date;
	
	private String time;
	
	private String customerEmail;

	public BookingResponseModel(String bookingId, String movieName, String numberOfTickets, String date, String time,
			String customerEmail) {
		super();
		this.bookingId = bookingId;
		this.movieName = movieName;
		this.numberOfTickets = numberOfTickets;
		this.date = date;
		this.time = time;
		this.customerEmail = customerEmail;
	}

	public BookingResponseModel() {
		// TODO Auto-generated constructor stub
	}

}

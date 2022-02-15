package com.movie.managment.model.booking;


import com.movie.managment.model.CinemaSeat;
import com.movie.managment.model.customer.Customer;
import com.movie.managment.model.show.Show;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestModel {
	private String bookingId;
	
	private String movieName;
	
	private String numberOfTickets;
	
	private String date;
	
	private String time;
	
	private String customerEmail;

	public BookingRequestModel(String bookingId, String movieName, String numberOfTickets, String date, String time,
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

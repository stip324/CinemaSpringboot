package com.movie.managment.model.booking;

import com.movie.managment.model.CinemaSeat;
import com.movie.managment.model.customer.Customer;
import com.movie.managment.model.show.Show;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseModel {
private String bookingId;
	
	private CinemaSeat seatNumber;
	

	private Show show;
	
	private Customer customer;
	public BookingResponseModel() {}
	public BookingResponseModel(String bookingId, CinemaSeat seatNumber, Show show, Customer customer) {
		super();
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.show = show;
		this.customer = customer;
	}

}

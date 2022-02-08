package com.movie.managment.model.booking;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.movie.managment.model.CinemaSeat;
import com.movie.managment.model.customer.Customer;
import com.movie.managment.model.show.Show;

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
	
	@OneToOne
	private CinemaSeat seatNumber;
	
	@OneToOne
	private Show show;
	
	@ManyToOne
	private Customer customer;
	
	
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	

	public Booking(String bookingId, CinemaSeat seatNumber, Show show, Customer customer) {
		super();
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.show = show;
		this.customer = customer;
	}

}

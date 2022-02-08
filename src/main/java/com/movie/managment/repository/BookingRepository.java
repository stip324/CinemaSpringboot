package com.movie.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.managment.model.booking.Booking;


public interface BookingRepository extends JpaRepository<Booking,String> {

}

package com.movie.managment.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.managment.model.booking.Booking;
import com.movie.managment.model.booking.BookingRequestModel;
import com.movie.managment.model.booking.BookingResponseModel;
import com.movie.managment.repository.BookingRepository;

@Service
public class BookingServiceImpl {

	@Autowired
	BookingRepository BookingRepository;

	public BookingResponseModel createBooking(BookingRequestModel request) {
		Booking booking =new Booking();
		booking.setBookingId(UUID.randomUUID().toString());
		booking.setCustomerEmail(request.getCustomerEmail());
		booking.setDate(request.getDate());
		booking.setMovieName(request.getMovieName());
		booking.setNumberOfTickets(request.getNumberOfTickets());
		booking.setTime(request.getTime());
		BookingRepository.save(booking);
		BookingResponseModel response =new BookingResponseModel();
		response.setBookingId(booking.getBookingId());
		response.setCustomerEmail(booking.getCustomerEmail());
		response.setDate(booking.getDate());
		response.setMovieName(booking.getMovieName());
		response.setNumberOfTickets(booking.getNumberOfTickets());
		response.setTime(booking.getTime());

		return response;

	}

	public List<BookingResponseModel> getAllBooking() {
		ModelMapper mapper = new ModelMapper();
		List<BookingResponseModel> returnList = new ArrayList<BookingResponseModel>();

		List<Booking> list = BookingRepository.findAll();

		for (Booking c : list) {
			BookingResponseModel modelObject = mapper.map(c, BookingResponseModel.class);
			returnList.add(modelObject);
		}

		return returnList;
	}
	
	public BookingResponseModel getBookingById(String Id) {
		Optional<Booking> optional = BookingRepository.findById(Id);

		if (optional.isPresent()) {
			Booking c = optional.get();
			ModelMapper mapper = new ModelMapper();
			BookingResponseModel returnObject = mapper.map(c, BookingResponseModel.class);
			return returnObject;
		}

		return null;
		
	}
	
	public BookingResponseModel updateBooking(String id, BookingRequestModel requestModel) {
		Optional<Booking> optional = BookingRepository.findById(id);
		if (optional.isPresent()) {
			ModelMapper mapper = new ModelMapper();
			Booking c = mapper.map(requestModel, Booking.class);
			c.setBookingId(id);
			BookingRepository.save(c);
			BookingResponseModel trm = mapper.map(c, BookingResponseModel.class);
			return trm;
		}

		return null;

	}

	public void deleteBooking(String id) {
		BookingRepository.deleteById(id);
	}

}

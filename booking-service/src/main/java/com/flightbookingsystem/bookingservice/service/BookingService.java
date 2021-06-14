package com.flightbookingsystem.bookingservice.service;

import java.util.List;
import java.util.Optional;

import com.flightbookingsystem.bookingservice.model.Booking;


public interface BookingService {
	
	Optional<Booking> getById(int bookingid);

	List<Booking> getAllBooking();
	
	Booking addNewBooking(Booking booking);

	Booking updateBooking(Booking booking);

	Booking deleteById(int bookingid);

}

package com.flightbookingsystem.bookingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightbookingsystem.bookingservice.model.Booking;
import com.flightbookingsystem.bookingservice.repository.BookingRepository;

public class BookingServiceImpl implements BookingService  {
	
	@Autowired
	private BookingRepository bookingRepo;

	@Override
	public Optional<Booking> getById(int bookingid) {
		
		return bookingRepo.findByBookingid(bookingid);
	}

	@Override
	public List<Booking> getAllBooking() {
		
		return bookingRepo.findAll();
	}

	@Override
	public Booking addNewBooking(Booking booking) {
		
		return bookingRepo.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		
		return bookingRepo.save(booking);
	}

	@Override
	public Booking deleteById(int bookingid) {
		
		return bookingRepo.deleteByBookingid(bookingid);
	}

}

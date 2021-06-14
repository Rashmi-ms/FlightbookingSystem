package com.flightbookingsystem.bookingservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbookingsystem.bookingservice.model.Booking;
import com.flightbookingsystem.bookingservice.repository.BookingRepository;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@PostMapping("/addbooking")
	public String saveBooking(@RequestBody Booking booking) {
		bookingRepo.save(booking);
		return "Added booking with id:" + booking.getBookingid();
	}
	
	@GetMapping("/findAllBooking")
	public List<Booking> getBooking(){
		return bookingRepo.findAll();
	}
	
	@GetMapping("/findAllBooking/{bookingid}")
	public Optional<Booking> getBooking(@PathVariable int bookingid){
		return bookingRepo.findByBookingid(bookingid);
	}
	
	@DeleteMapping("/delete/{bookingid}")
	public String deleteBooking(@PathVariable int bookingid) {
		bookingRepo.deleteByBookingid(bookingid);
		return "booking deleted with id:"+bookingid;
	}
	
	@PutMapping("/update/{bookingid}")
	public Booking updateBooking(@PathVariable int bookingid, @RequestBody Booking booking) {
		booking.setBookingid(bookingid);
		bookingRepo.save(booking);
		return booking;
	}
		

}

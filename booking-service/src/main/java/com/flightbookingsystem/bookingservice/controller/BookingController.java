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
	BookingRepository bookingRepo;
	
	@PostMapping("/addbooking")
	public String saveBooking(@RequestBody Booking booking) {
		bookingRepo.save(booking);
		return "Added booking with id:" + booking.getId();
	}
	
	@GetMapping("/findAllBooking")
	public List<Booking> getBooking(){
		return bookingRepo.findAll();
	}
	
	@GetMapping("/findAllBooking/{id}")
	public Optional<Booking> getBooking(@PathVariable int id){
		return bookingRepo.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBooking(@PathVariable int id) {
		bookingRepo.deleteById(id);
		return "booking deleted with id:"+id;
	}
	
	@PutMapping("/update/{id}")
	public Booking updateBooking(@PathVariable int id, @RequestBody Booking booking) {
		booking.setId(id);
		bookingRepo.save(booking);
		return booking;
	}
	
	
	
	
	
	
	

}

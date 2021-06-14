package com.flightbookingsystem.bookingservice.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.flightbookingsystem.bookingservice.model.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String>{

	Optional<Booking> findByBookingid(int bookingid);

	Booking deleteByBookingid(int bookingid);
	

}

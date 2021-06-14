package com.flightbookingsystem.passengerservice.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightbookingsystem.passengerservice.model.Booking;




@Repository
public interface BookingRepository extends MongoRepository<Booking, String>{

	
	

}

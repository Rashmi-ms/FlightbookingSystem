package com.flightbooking.adminservice.repository;




import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.adminservice.model.Booking;




@Repository
public interface BookingRepository extends MongoRepository<Booking, String>{

	List<Booking> findByBookingId(int bookingid);

	

}

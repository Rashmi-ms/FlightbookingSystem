package com.flightbooking.checkinserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.checkinserver.model.Booking;

@Repository
public interface CheckinRepository  extends MongoRepository<Booking,String> {

	Booking findByBookingid(int bookingid);

}

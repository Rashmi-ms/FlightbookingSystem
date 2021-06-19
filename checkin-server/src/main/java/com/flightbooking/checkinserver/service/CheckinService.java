package com.flightbooking.checkinserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.checkinserver.model.Booking;
import com.flightbooking.checkinserver.repository.CheckinRepository;

@Service
public class CheckinService {
	
	@Autowired
	 private CheckinRepository repo;
	
	
	public String getPassengerDetailsByBookingid(int bookingid) {
		
		List<Booking> booking =repo.findAll();
		for(Booking x: booking ) {
			if(x.getBookingid() == bookingid) {
				x.setMsg("booked successfully");
				repo.save(x);
			}	
		}
		return  "You have " +repo.findByBookingid(bookingid).getMsg();
	}

}

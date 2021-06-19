package com.flightbooking.checkinserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.checkinserver.service.CheckinService;
@RestController
@RequestMapping("/checkin")
public class CheckinController {
	
	@Autowired 
    private CheckinService cs;
	
	@GetMapping("/get/{bookingid}")
	public String getPassengerDetailsByid(@PathVariable int bookingid )
	{
		return cs.getPassengerDetailsByBookingid(bookingid);
	}

}

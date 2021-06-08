package com.flightbooking.checkinserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CheckinController {
	
	@GetMapping("/checkin")
	public String test() {
		return "In CheckIn Service";
	}

}

package com.flightbookingsystem.flightservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
	
	@GetMapping("/helloflight")
	public String test() {
		return "Hello Flight Service";
	}

}

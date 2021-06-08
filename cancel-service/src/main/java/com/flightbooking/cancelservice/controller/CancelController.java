package com.flightbooking.cancelservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CancelController {
	
	@GetMapping("/cancel")
	public String test() {
		return "In Cancel Service";
	}

}

package com.flightbookingsystem.passengerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PassengerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/hello")
	public String test() {
		return restTemplate.getForObject("http://localhost:8082/helloflight",String.class);
	}
	
	@GetMapping("/hello1")
	public String test1() {
		return restTemplate.getForObject("http://localhost:8083/hellobooking",String.class);
	}
	
	@GetMapping("/hello2")
	public String test2() {
		return restTemplate.getForObject("http://localhost:8084/hellopayment",String.class);
	}

}

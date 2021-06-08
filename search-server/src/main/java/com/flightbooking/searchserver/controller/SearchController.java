package com.flightbooking.searchserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
	
	@GetMapping("/search")
	public String test() {
		return "In Search Service";
	}

}

package com.flightbooking.checkfareserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CheckfareController {

	@GetMapping("/checkfare")
	public String test() {
		return "In Check fare Service";
	}
}

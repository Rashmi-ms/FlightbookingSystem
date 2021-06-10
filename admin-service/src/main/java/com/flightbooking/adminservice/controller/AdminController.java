package com.flightbooking.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.flightbooking.adminservice.model.Flight;
import com.flightbooking.adminservice.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@GetMapping("/all")
	public List<Flight> getAllDetails() {
		return adminServiceImpl.getAllDetails();
	}
	
	@GetMapping("/{flightnumber}")
	public Flight getDetailsByFlightnumber(@PathVariable String flightnumber) 
	{
		return adminServiceImpl.getDetailsByFlightnumber(flightnumber);
	}
	
	@PostMapping("/add")
	public String addFlight(@RequestBody Flight flights) {
		adminServiceImpl.addFlights(flights);
		return ("Added flight details with flight number - " + flights.getFlightnumber() + " successfully..!!");
	}
	
	@DeleteMapping("/delete/{flightnumber}")
	public ResponseEntity<Flight> deleteFlightsDetails(@PathVariable String flightnumber)
	{
		return adminServiceImpl.deleteFlights(flightnumber);
	}
	
	@PutMapping("/update/{flightnumber}")
	public Flight updateFlightsDetails(@PathVariable String flightnumber, @RequestBody Flight flights)
	{
		flights.setFlightnumber(flightnumber);
	    adminServiceImpl.saveFlights(flights);
	    return flights;
	}
	
	
//	@Autowired
//	private PassengerRepo repo;
//	
//	@GetMapping("/allpassenger")
//	public List<Passenger> getAllPassenger() {
//		return repo.getAllPassenger();
//	}
	
}
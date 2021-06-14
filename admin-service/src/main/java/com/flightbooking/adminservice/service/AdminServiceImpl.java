package com.flightbooking.adminservice.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightbooking.adminservice.model.Flight;
import com.flightbooking.adminservice.repository.FlightRepository;

@Service
public class AdminServiceImpl  {
	
	@Autowired
	private FlightRepository repository;

	public List<Flight> getAllDetails() {
		List<Flight> flights = new ArrayList<Flight>();
		repository.findAll().forEach(flights1 -> flights.add(flights1));
		return flights;
	}

	public void addFlights(Flight flights) {
		repository.save(flights);
		
	}

	/*
	 * public Flight getDetailsByFlightnumber(String flightnumber) { return
	 * repository.findByFlightnumber(flightnumber); }
	 * 
	 * 
	 * public ResponseEntity<Flight> deleteFlights(String flightnumber) { Flight
	 * existingDetails=repository.findByFlightnumber(flightnumber);
	 * repository.delete(existingDetails); return ResponseEntity.ok().build(); }
	 */

	public void saveFlights(Flight flights) {
		repository.save(flights);
		
	}
}

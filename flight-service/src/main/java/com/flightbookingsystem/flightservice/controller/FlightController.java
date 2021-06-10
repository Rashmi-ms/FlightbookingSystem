package com.flightbookingsystem.flightservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightbookingsystem.flightservice.model.Flight;
import com.flightbookingsystem.flightservice.repository.FlightRepository;



@RestController
@RequestMapping("/flight")
public class FlightController {
	
	
	@Autowired
	private FlightRepository flightRepository;
	
	@PostMapping("/addFlight")
	public String saveFlight(@RequestBody Flight flight) {
		flightRepository.save(flight);
		return "Added Flight with id:" + flight.getFlightnumber();
	}
	
	@GetMapping("/findAllFlight")
	public List<Flight> getFlight(){
		return flightRepository.findAll();
	}
	
	@GetMapping("/findAllFlight/{flightnumber}")
	public Optional<Flight> getFlight(@PathVariable String flightnumber){
		return flightRepository.findByFlightnumber(flightnumber);
	}
	
	@DeleteMapping("/delete/{flightnumber}")
	public String deleteFlight(@PathVariable String flightnumber) {
		flightRepository.deleteByFlightnumber(flightnumber);
		return "Flight deleted with id:"+flightnumber;
	}
	
	@PutMapping("/update/{flightnumber}")
	public Flight updateFlight(@PathVariable String flightnumber, @RequestBody Flight flight) {
		flight.setFlightnumber(flightnumber);
		flightRepository.save(flight);
		return flight;
	}
	
}

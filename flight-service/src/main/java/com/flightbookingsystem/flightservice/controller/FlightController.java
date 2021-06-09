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
		return "Added Flight with id:" + flight.getFlightid();
	}
	
	@GetMapping("/findAllFlight")
	public List<Flight> getFlight(){
		return flightRepository.findAll();
	}
	
	@GetMapping("/findAllFlight/{flightid}")
	public Optional<Flight> getFlight(@PathVariable int flightid){
		return flightRepository.findByFlightid(flightid);
	}
	
	@DeleteMapping("/delete/{flightid}")
	public String deleteFlight(@PathVariable int flightid) {
		flightRepository.deleteByFlightid(flightid);
		return "Flight deleted with id:"+flightid;
	}
	
	@PutMapping("/update/{flightid}")
	public Flight updateFlight(@PathVariable int flightid, @RequestBody Flight flight) {
		flight.setFlightid(flightid);
		flightRepository.save(flight);
		return flight;
	}
	
}

package com.flightbookingsystem.flightservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightbookingsystem.flightservice.model.Flight;
import com.flightbookingsystem.flightservice.repository.FlightRepository;

public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Optional<Flight> getByFlightId(int flightid) {
		return flightRepository.findByFlightid(flightid);
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@Override
	public Flight addNewFlight(Flight flight) {
		return flightRepository.save(flight);
	}


	@Override
	public Flight updateFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public Flight deleteFlightById(int flightid) {
		return flightRepository.deleteByFlightid(flightid);
	}


}

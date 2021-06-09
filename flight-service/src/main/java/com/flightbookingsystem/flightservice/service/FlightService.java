package com.flightbookingsystem.flightservice.service;

import java.util.List;
import java.util.Optional;

import com.flightbookingsystem.flightservice.model.Flight;

public interface FlightService {
	
	Optional<Flight> getByFlightId(int flightid);

	List<Flight> getAllFlights();
	
	Flight addNewFlight(Flight flight);

	Flight updateFlight(Flight flight);

	Flight deleteFlightById(int flightid);

}


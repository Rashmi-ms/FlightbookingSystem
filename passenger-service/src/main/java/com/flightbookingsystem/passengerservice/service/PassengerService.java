package com.flightbookingsystem.passengerservice.service;

import java.util.List;
import java.util.Optional;

import com.flightbookingsystem.passengerservice.model.Passenger;

public interface PassengerService {
	
	Optional<Passenger> getById(int id);

	List<Passenger> getAllPassenger();
	
	Passenger addNewPassenger(Passenger passenger);

	Passenger updatePassenger(Passenger passenger);

	Passenger deleteById(int id);

}

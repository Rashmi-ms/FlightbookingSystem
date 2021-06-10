package com.flightbookingsystem.passengerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightbookingsystem.passengerservice.model.Passenger;
import com.flightbookingsystem.passengerservice.repository.PassengerRepository;

public class PassengerServiceImpl implements PassengerService{
	
	@Autowired
	private PassengerRepository repo;

	@Override
	public Optional<Passenger> getById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Passenger> getAllPassenger() {
		
		return repo.findAll();
	}

	@Override
	public Passenger addNewPassenger(Passenger passenger) {
		
		return repo.save(passenger);
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) {
		
		return repo.save(passenger);
	}

	@Override
	public Passenger deleteById(int id) {
		
		return repo.deleteById(id);
	}

}

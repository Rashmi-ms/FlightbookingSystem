package com.flightbookingsystem.passengerservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.flightbookingsystem.passengerservice.model.Passenger;


public interface PassengerRepository extends MongoRepository<Passenger,String> {

	Optional<Passenger> findById(int id);
	Passenger deleteById(int id);
	Passenger findByUsername(String username);
	
	

}


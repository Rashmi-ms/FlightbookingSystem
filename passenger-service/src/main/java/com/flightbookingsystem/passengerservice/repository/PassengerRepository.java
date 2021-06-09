package com.flightbookingsystem.passengerservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.flightbookingsystem.passengerservice.model.Passenger;


public interface PassengerRepository extends MongoRepository<Passenger,String> {

	void deleteByAge(int age);
	Optional<Passenger> findByAge(int age);

	
	

}


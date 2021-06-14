package com.flightbookingsystem.passengerservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightbookingsystem.passengerservice.model.Flight;


@Repository
public interface FlightRepository extends MongoRepository<Flight,String> {

	List<Flight> findByFlightnumber(String flightnumber);
	
	

}

package com.flightbookingsystem.flightservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightbookingsystem.flightservice.model.Flight;


@Repository
public interface FlightRepository extends MongoRepository<Flight,String> {

	
	Flight deleteByFlightid(int flightid);
	Optional<Flight> findByFlightid(int flightid);
	
	

}

package com.flightbooking.adminservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.adminservice.model.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight,String>  {

	List<Flight> findByFlightnumber(String flightnumber);

}

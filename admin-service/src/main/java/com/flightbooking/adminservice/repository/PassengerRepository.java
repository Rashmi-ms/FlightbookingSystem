package com.flightbooking.adminservice.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flightbooking.adminservice.model.Passenger;



public interface PassengerRepository extends MongoRepository<Passenger,String> {

	List<Passenger> findById(int id);
	
	

}


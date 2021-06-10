package com.flightbooking.adminservice.repository;




import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.flightbooking.adminservice.model.Flight;


@Repository
public interface AdminRepository extends MongoRepository<Flight,String>  {

	Flight findByFlightnumber(String flightnumber);

	

}

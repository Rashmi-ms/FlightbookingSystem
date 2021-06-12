package com.flightbookingsystem.passengerservice.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightbookingsystem.passengerservice.model.Flight;
import com.flightbookingsystem.passengerservice.model.Passenger;
import com.flightbookingsystem.passengerservice.repository.FlightRepository;
import com.flightbookingsystem.passengerservice.repository.PassengerRepository;


@RestController
@RequestMapping("/Passenger")
public class PassengerController {
	
	@Autowired 
	private FlightRepository repository;
	
	
	@Autowired
    private RestTemplate restTemplate;
	
	//list of flight
		 @RequestMapping("/{flight_name}")
		 public List<Flight> getFlights(@PathVariable("flight_name") String flight_name) {

		 restTemplate.getForObject("http://localhost:8082/flight/findAllFlight/" + flight_name, Flight.class);
		
		 return repository.findAll();
		        }
	
	
	/*
	 * @RequestMapping("/{flightnumber}") public String
	 * getFlight(@PathVariable("flightnumber") String flightnumber) {
	 * 
	 * Flight flight =
	 * restTemplate.getForObject("http://localhost:8082/flight/findAllFlight/" +
	 * flightnumber, Flight.class);
	 * 
	 * return flight.getFlight_name(); }
	 */
	 
	 
	 
	         //CURD operation 
			
			  @Autowired 
			  private PassengerRepository repo;
			  
			  
			  @PostMapping("/addPassenger") 
			  public String savePassenger(@RequestBody Passenger passenger) {
				  repo.save(passenger); 
				  return  "added passenger with id:" + passenger.getId(); }
			  
			  
			  
			  @GetMapping("/findAllPassenger")
			  public List<Passenger> getPassenger(){
			  return repo.findAll(); 
			  }
			  
			  
			  
			  @GetMapping("/findAllPassenger/{id}") public
			  Optional<Passenger>getPassenger(@PathVariable int id){ return
			  repo.findById(id); }
			  
			  
			  
			  @DeleteMapping("/delete/{id}") 
			  public String deletePassenger(@PathVariable  int id) {
				  repo.deleteById(id); 
				  return "Passenger deleted with id:"+id;
				  }
			  
			  @PutMapping("/update/{age}") public Passenger updatePassenger(@PathVariable
			  int age, @RequestBody Passenger passenger) { passenger.setAge(age);
			  repo.save(passenger); return passenger; }
			 
	
	
	 

}

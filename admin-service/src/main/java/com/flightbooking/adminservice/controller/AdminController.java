package com.flightbooking.adminservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightbooking.adminservice.model.Admin;
import com.flightbooking.adminservice.model.Flight;
import com.flightbooking.adminservice.model.Passenger;
import com.flightbooking.adminservice.repository.AdminRepository;
import com.flightbooking.adminservice.repository.FlightRepository;
import com.flightbooking.adminservice.repository.PassengerRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	 private RestTemplate restTemplate;
	
	@Autowired
	private PassengerRepository repo;
	
	//gives list of passengers 
	 @RequestMapping("/findAllPassenger/{id}")
	 public List<Passenger> getPassenger(@PathVariable("id") int id) {

	 restTemplate.getForObject("http://localhost:8081/Passenger/findAllPassenger/" +id,Passenger.class);
	
	 return repo.findAll();
	        }
	         
			/*
			 * @PostMapping("/addPassenger") public String savePassenger(@RequestBody
			 * Passenger passenger) {
			 * restTemplate.getForObject("http://localhost:8081/Passenger/addPassenger",
			 * Passenger.class); repo.save(passenger); return "added passenger with id:" +
			 * passenger.getId(); }
			 * 
			 * @DeleteMapping("/delete/{id}") public String deletePassenger(@PathVariable
			 * int id) { restTemplate.getForObject("http://localhost:8081/Passenger/delete/"
			 * + id, Passenger.class); repo.deleteById(id); return
			 * "Passenger deleted with id:"+id; }
			 */
	 
	 @Autowired
	 private FlightRepository flightrepo;
	 
	 //gives list of flights
	 @RequestMapping("/findAllFlight/{flight_name}")
	 public List<Flight> getFlights(@PathVariable("flight_name") String flight_name) {

	 restTemplate.getForObject("http://localhost:8082/flight/findAllFlight/" + flight_name, Flight.class);
	
	 return flightrepo.findAll();
	        }
	 
	
	@Autowired
	private AdminRepository repository;
	
	//gives all admins
	@GetMapping("/findAllAdmin")
	public List<Admin> getAdmins(){
		return repository.findAll();
	}
    
	//gives admin with id
	@GetMapping("/findAllAdmin/{id}")
	public Optional<Admin> getAdmins(@PathVariable int id){
		return repository.findById(id);
	}
	

	
}
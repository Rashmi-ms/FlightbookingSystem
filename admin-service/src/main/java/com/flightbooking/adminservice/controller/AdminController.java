package com.flightbooking.adminservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightbooking.adminservice.model.Admin;
import com.flightbooking.adminservice.model.Booking;
import com.flightbooking.adminservice.model.Flight;
import com.flightbooking.adminservice.model.Passenger;
import com.flightbooking.adminservice.repository.AdminRepository;
import com.flightbooking.adminservice.repository.BookingRepository;
import com.flightbooking.adminservice.repository.FlightRepository;
import com.flightbooking.adminservice.repository.PassengerRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
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
	
	@Autowired
	 private RestTemplate restTemplate;
	
	@Autowired
	private PassengerRepository repo;
	
	//returns passenger of the given id
	 @RequestMapping(value = "/findAllPassenger/{id}",method = RequestMethod.GET)
	 public List<Passenger> getPassenger(@PathVariable("id") int id) {

	 restTemplate.getForObject("http://localhost:8081/Passenger/findAllPassenger/" +id,Passenger.class);
	
	 return repo.findById(id);
	        }
	 //returns list of passengers
	 @RequestMapping(value = "/findAllPassenger", method = RequestMethod.GET)
	 public Passenger[] getPassenger() {

	 ResponseEntity<Passenger[]> response = restTemplate.getForEntity("http://localhost:8081/Passenger/findAllPassenger" ,Passenger[].class);
	
	 return response.getBody();
	        }
	         
	 //adds new passenger
	  @RequestMapping(value = "/addPassenger",method = RequestMethod.POST)
	     public String addNewPassenger(@RequestBody  Passenger passenger)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Passenger> entity = new  HttpEntity<Passenger>(passenger,headers);
	         return restTemplate.exchange("http://localhost:8081/Passenger/addPassenger", HttpMethod.POST, entity, String.class).getBody();

	     }
	  //delete passenger with the given id
	  @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	     public String deletePassengerById(@PathVariable("id") int id)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Passenger> entity = new  HttpEntity<Passenger>(headers);
	         return restTemplate.exchange("http://localhost:8081/Passenger/delete/"+ id, HttpMethod.DELETE, entity, String.class).getBody();

	     }
	  
	  //update passenger with the given id
	  @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	     public String updatePassenger(@PathVariable("id") int id, @RequestBody Passenger passenger)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Passenger> entity = new  HttpEntity<Passenger>(passenger,headers);
	         return restTemplate.exchange("http://localhost:8081/Passenger/update/"+ id, HttpMethod.PUT, entity, String.class).getBody();

	     }
			  			 
			 
	 
	 @Autowired
	 private FlightRepository flightrepo;
	 
	 //returns flight of the given flightnumber
	 @RequestMapping(value="/findAllFlight/{flightnumber}",method = RequestMethod.GET)
	 public List<Flight> getFlight(@PathVariable("flightnumber") String flightnumber) {

	 restTemplate.getForObject("http://localhost:8082/flight/findAllFlight/" + flightnumber, Flight.class);
	
	 return flightrepo.findByFlightnumber(flightnumber);
	        }
	 
	 //returns list of flight
	 @RequestMapping(value = "/findAllFlight",method = RequestMethod.GET)
	 public Flight[] getFlight() {

	 ResponseEntity<Flight[]> response = restTemplate.getForEntity("http://localhost:8082/flight/findAllFlight" ,Flight[].class);
	
	 return response.getBody();
	        }
	 
	//add new flight
	  @RequestMapping(value = "/addFlight",method = RequestMethod.POST)
	     public String addNewFlight(@RequestBody  Flight flight)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Flight> entity = new  HttpEntity<Flight>(flight,headers);
	         return restTemplate.exchange("http://localhost:8082/flight/addFlight", HttpMethod.POST, entity, String.class).getBody();

	     }
	  //delete flight with the given flightnumber
	  @RequestMapping(value = "/delete/{flightnumber}",method = RequestMethod.DELETE)
	     public String deleteFlight(@PathVariable("flightnumber") String flightnumber)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Flight> entity = new  HttpEntity<Flight>(headers);
	         return restTemplate.exchange("http://localhost:8082/flight/delete/"+ flightnumber, HttpMethod.DELETE, entity, String.class).getBody();

	     }
	  
	  //update flight with the given flightnumber
	  @RequestMapping(value = "/update/{flightnumber}",method = RequestMethod.PUT)
	     public String updateFlight(@PathVariable("flightnumber") String flightnumber, @RequestBody Flight flight)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Flight> entity = new  HttpEntity<Flight>(flight,headers);
	         return restTemplate.exchange("http://localhost:8082/flight/update/"+ flightnumber, HttpMethod.PUT, entity, String.class).getBody();

	     }
	 
	 @Autowired
	 private BookingRepository bookrepo;
	 
	 //all booking
	 @RequestMapping(value = "/findAllBooking/{bookingid}", method = RequestMethod.GET)
	 public List<Booking> getBooking(@PathVariable("bookingid") int bookingid) {

	 restTemplate.getForObject("http://localhost:8083/booking/findAllBooking/" + bookingid, Booking.class);
	
	 return bookrepo.findAll();
	        }
	 	
}
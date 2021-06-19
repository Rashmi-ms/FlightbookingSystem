package com.flightbookingsystem.passengerservice.controller;


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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightbookingsystem.passengerservice.model.Booking;
import com.flightbookingsystem.passengerservice.model.Flight;
import com.flightbookingsystem.passengerservice.model.Passenger;
import com.flightbookingsystem.passengerservice.repository.PassengerRepository;


@RestController
@RequestMapping("/Passenger")
public class PassengerController {
	
	
	@Autowired
    private RestTemplate restTemplate;
	
	//returns list of flight
	 @RequestMapping(value = "/findAllFlight",method = RequestMethod.GET)
	 public Flight[] getFlight() {
	 ResponseEntity<Flight[]> response = restTemplate.getForEntity("http://localhost:8082/flight/findAllFlight" ,Flight[].class);	
	 return response.getBody();
	 }
	 
	//returns flight of the given flightnumber
	 @RequestMapping(value="/findAllFlight/{flightnumber}",method = RequestMethod.GET)
	 public String getFlight(@PathVariable("flightnumber") String flightnumber) {
	     
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Flight> entity = new  HttpEntity<Flight>(headers);
	         return restTemplate.exchange("http://localhost:8082/flight/findAllFlight/" + flightnumber, HttpMethod.GET, entity, String.class).getBody();

	     }
	
    
  //add new booking
	  @RequestMapping(value = "/addbooking",method = RequestMethod.POST)
	     public String addNewBooking(@RequestBody  Booking booking)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Booking> entity = new  HttpEntity<Booking>(booking,headers);
	         return restTemplate.exchange("http://localhost:8083/booking/addbooking", HttpMethod.POST, entity, String.class).getBody();
	     }
	  
	//update booking with the  bookingid
	  @RequestMapping(value = "/booking/update/{bookingid}",method = RequestMethod.PUT)
	     public String updateBooking(@PathVariable("bookingid") int bookingid, @RequestBody Booking booking)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Booking> entity = new  HttpEntity<Booking>(booking,headers);
	         return restTemplate.exchange("http://localhost:8083/booking/update/"+ bookingid, HttpMethod.PUT, entity, String.class).getBody();
	     }
	  
	//delete booking with bookingid	  
	  @RequestMapping(value = "/booking/delete/{bookingid}",method = RequestMethod.DELETE)
	     public String deleteBookingByBookingid(@PathVariable("bookingid") int bookingid)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Booking> entity = new  HttpEntity<Booking>(headers);
	         return restTemplate.exchange("http://localhost:8083/booking/delete/"+ bookingid, HttpMethod.DELETE, entity, String.class).getBody();
	     }
	  
	//return booking with bookingid
		 @RequestMapping(value = "/findAllBooking/{bookingid}", method = RequestMethod.GET)
		 public String getBooking(@PathVariable("bookingid") int bookingid) {
		     
		         HttpHeaders headers = new HttpHeaders();
		         headers.setContentType(MediaType.APPLICATION_JSON);
		         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		         HttpEntity<Booking> entity = new  HttpEntity<Booking>(headers);
		         return restTemplate.exchange("http://localhost:8083/booking/findAllBooking/" + bookingid, HttpMethod.GET, entity, String.class).getBody();

		     }
	  
	  
	//returns booking status
//		 @RequestMapping(value="/checkin/get/{bookingid}",method = RequestMethod.GET)
//		 public List<Booking> getBooking(@PathVariable("bookingid") int bookingid) {
//		 restTemplate.getForObject("http://localhost:8089/checkin/get/" + bookingid, Booking.class);
//		 return repos.findByBookingid(bookingid);
//		 }
		 	 
//CURD operation 
			
	  @Autowired 
	  private PassengerRepository repo;
			  	  
	  @PostMapping("/addPassenger") 
	  public String savePassenger(@RequestBody Passenger passenger) {
	  repo.save(passenger); 
	  return  "added passenger with id:" + passenger.getId();
	  }
					  		  
	  @GetMapping("/findAllPassenger")
	  public List<Passenger> getPassenger(){
	  return repo.findAll(); 
	  }
			  	  
	 @GetMapping("/findAllPassenger/{id}") 
	 public Optional<Passenger>getPassenger(@PathVariable int id){
	 return repo.findById(id); 
	 }
			  	  
	 @DeleteMapping("/delete/{id}") 
	  public String deletePassenger(@PathVariable  int id) {
	  repo.deleteById(id); 
	  return "Passenger deleted with id:"+id;
	  }
			  
	 @PutMapping("/update/{id}")
	  public Passenger updatePassenger(@PathVariable int id, @RequestBody Passenger passenger) {
	  passenger.setId(id);
	  repo.save(passenger); 
	  return passenger;
			  }
}

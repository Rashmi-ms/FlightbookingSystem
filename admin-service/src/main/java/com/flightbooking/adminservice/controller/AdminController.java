package com.flightbooking.adminservice.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightbooking.adminservice.model.Booking;
import com.flightbooking.adminservice.model.Flight;
import com.flightbooking.adminservice.model.Passenger;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	 private RestTemplate restTemplate;
	

	 //returns list of passengers
	 @RequestMapping(value = "/findAllPassenger", method = RequestMethod.GET)
	 public Passenger[] getPassenger() {
	 ResponseEntity<Passenger[]> response = restTemplate.getForEntity("http://localhost:8081/Passenger/findAllPassenger" ,Passenger[].class);	
	 return response.getBody();
	        }
	 
	//returns passenger of the given id
	 @RequestMapping(value = "/findAllPassenger/{id}",method = RequestMethod.GET)
	  public String getPassenger(@PathVariable("id") int id)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Passenger> entity = new  HttpEntity<Passenger>(headers);
	         return restTemplate.exchange("http://localhost:8081/Passenger/findAllPassenger/"+ id, HttpMethod.GET, entity, String.class).getBody();

	     }
	         
	  //delete passenger with the given id
	  @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	   public String deletePassenger(@PathVariable("id") int id)
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
	  @RequestMapping(value = "flight/delete/{flightnumber}",method = RequestMethod.DELETE)
	     public String deleteFlight(@PathVariable("flightnumber") String flightnumber)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Flight> entity = new  HttpEntity<Flight>(headers);
	         return restTemplate.exchange("http://localhost:8082/flight/delete/"+ flightnumber, HttpMethod.DELETE, entity, String.class).getBody();
	     }
	  
	  //update flight with the given flightnumber
	  @RequestMapping(value = "flight/update/{flightnumber}",method = RequestMethod.PUT)
	     public String updateFlight(@PathVariable("flightnumber") String flightnumber, @RequestBody Flight flight)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Flight> entity = new  HttpEntity<Flight>(flight,headers);
	         return restTemplate.exchange("http://localhost:8082/flight/update/"+ flightnumber, HttpMethod.PUT, entity, String.class).getBody();

	     }
	 
	 
	//returns all booking
		 @RequestMapping(value = "/findAllBooking", method = RequestMethod.GET)
		 public Booking[] getBooking() {
		 ResponseEntity<Booking[]> response = restTemplate.getForEntity("http://localhost:8083/booking/findAllBooking" ,Booking[].class);	
		 return response.getBody();
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
	 	
}
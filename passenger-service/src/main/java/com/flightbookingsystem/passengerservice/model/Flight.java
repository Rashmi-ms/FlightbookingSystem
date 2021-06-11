package com.flightbookingsystem.passengerservice.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="flight")
public class Flight {
	
	@Id
	private String _id;
	
	private String flightnumber;
	private String flight_name;
	private String source;
	private String destination;
	private String departure_time;
	private String arrival_time;
	private int flight_fare;
	
	public Flight() {
		
	}
	
	
	public Flight(String _id, String flightnumber, String flight_name, String source, String destination,
			String departure_time, String arrival_time, int flight_fare) {
		super();
		this._id = _id;
		this.flightnumber = flightnumber;
		this.flight_name = flight_name;
		this.source = source;
		this.destination = destination;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.flight_fare = flight_fare;
	}


	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getFlightnumber() {
		return flightnumber;
	}


	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	
	

	public String getFlight_name() {
		return flight_name;
	}


	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getDeparture_time() {
		return departure_time;
	}


	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}


	public String getArrival_time() {
		return arrival_time;
	}


	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}


	public int getFlight_fare() {
		return flight_fare;
	}


	public void setFlight_fare(int flight_fare) {
		this.flight_fare = flight_fare;
	}
	
	

	
}

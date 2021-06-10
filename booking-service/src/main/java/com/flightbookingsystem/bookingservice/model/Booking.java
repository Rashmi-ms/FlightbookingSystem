package com.flightbookingsystem.bookingservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Document("passenger" "flight")
//@Document("booking")//creates new collection when we run
public class Booking {
	
	@Id
	private int id;
	private String passengerName;
	private String source;
	private String destination;
	private Date travelDate;
	//private int flightid;
	//private int fare;
	
	public Booking() {
		
	}

	public Booking(int id, String passengerName, String source, String destination, Date travelDate) {
		super();
		this.id = id;
		this.passengerName = passengerName;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source= source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

}

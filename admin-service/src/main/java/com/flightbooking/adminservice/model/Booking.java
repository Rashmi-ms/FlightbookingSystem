package com.flightbooking.adminservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("booking")
public class Booking {
	
	@Id
	private String _id;
	
	private int bookingid;
	private String passengerName;
	private String source;
	private String destination;
	private Date travelDate;
	private String flightnumber;
	private int flight_fare;
	
	public Booking() {
		
	}

	public Booking(String _id, int bookingid, String passengerName, String source, String destination, Date travelDate,
			String flightnumber, int flight_fare) {
		super();
		this._id=_id;
		this.bookingid = bookingid;
		this.passengerName = passengerName;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
		this.flightnumber = flightnumber;
		this.flight_fare = flight_fare;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
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
		this.source = source;
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

	public String getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}

	public int getFlight_fare() {
		return flight_fare;
	}

	public void setFlight_fare(int flight_fare) {
		this.flight_fare = flight_fare;
	}

	

}

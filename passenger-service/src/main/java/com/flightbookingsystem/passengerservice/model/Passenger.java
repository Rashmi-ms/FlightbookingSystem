package com.flightbookingsystem.passengerservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="passenger")
public class Passenger {
	
	@Id
	private String _id;
	
	
	private String name;
	private String username;
	private String password;
	private String email;
	private int age;
	private String gender;
	private Object address;
	private int user_id;
	


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id =  _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Object getAddress() {
		return address;
	}

	public void setAddress(Object address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Passenger [_id=" + _id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", age=" + age + ", gender=" + gender + ", address=" + address + "]";
	}

	
	
	
	

}

package com.flightbooking.adminservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="admin")
public class Admin {
	
	@Id
	private String _id;
	
	private int id;
	private String name;
	private String username;
	private String password;
	private String email;
	
	public Admin() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
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
	public Admin(String _id, int id, String name, String username, String password, String email) {
		super();
		this._id = _id;
		this.id=id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

}

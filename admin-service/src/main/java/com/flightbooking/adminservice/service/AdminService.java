package com.flightbooking.adminservice.service;

import java.util.List;
import java.util.Optional;

import com.flightbooking.adminservice.model.Admin;


public interface AdminService {
	
	Optional<Admin> getById(int id);

	List<Admin> getAllAdmins();
	
	Admin addNewFlight(Admin admin);

	Admin updateFlight(Admin admin);

	Admin deleteById(int id);

}

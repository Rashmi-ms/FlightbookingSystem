package com.flightbooking.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightbooking.adminservice.model.Admin;
import com.flightbooking.adminservice.repository.AdminRepository;

public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository repository;

	@Override
	public Optional<Admin> getById(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Admin> getAllAdmins() {
		
		return repository.findAll();
	}

	@Override
	public Admin addNewFlight(Admin admin) {
		
		return repository.save(admin);
	}

	@Override
	public Admin updateFlight(Admin admin) {
		
		return repository.save(admin);
	}

	@Override
	public Admin deleteById(int id) {
		
		return repository.deleteById(id);
	}

}

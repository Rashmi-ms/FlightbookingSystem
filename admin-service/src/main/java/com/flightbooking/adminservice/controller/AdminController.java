package com.flightbooking.adminservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.adminservice.model.Admin;
import com.flightbooking.adminservice.repository.AdminRepository;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminRepository repository;
		
	
	@PostMapping("/addAdmin")
	public String saveAdmins(@RequestBody Admin admin) {
		repository.save(admin);
		return "added admin with id:" + admin.getId();
	}
	
	@GetMapping("/findAllAdmin")
	public List<Admin> getAdmins(){
		return repository.findAll();
	}
	
	@GetMapping("/findAllAdmin/{id}")
	public Optional<Admin> getAdmins(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAdmins(@PathVariable int id) {
		repository.deleteById(id);
		return "admin deleted with id:"+id;
	}
	
	@PutMapping("/update/{id}")
	public Admin updateAdmins(@PathVariable int id, @RequestBody Admin admin) {
		admin.setId(id);
		repository.save(admin);
		return admin;
	}
}

package com.flightbooking.adminservice.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.adminservice.model.Admin;


@Repository
public interface AdminRepository extends MongoRepository<Admin,String>  {

	Optional<Admin> findById(int id);

	Admin deleteById(int id);

}

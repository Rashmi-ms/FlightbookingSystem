package com.flightbookingsystem.passengerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "Resources")
@EnableEurekaClient
@EnableMongoRepositories(basePackages = "com.flightbookingsystem.passengerservice.repository")
public class PassengerServiceApplication {
	
	 

	public static void main(String[] args) {
		SpringApplication.run(PassengerServiceApplication.class, args);
	}

}

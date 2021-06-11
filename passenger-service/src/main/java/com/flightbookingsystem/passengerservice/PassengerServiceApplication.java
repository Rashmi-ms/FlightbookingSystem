package com.flightbookingsystem.passengerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
@EnableSwagger2
public class PassengerServiceApplication {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(PassengerServiceApplication.class, args);
	}

}

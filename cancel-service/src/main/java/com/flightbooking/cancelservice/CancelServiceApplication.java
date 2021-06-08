package com.flightbooking.cancelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.flightbooking.cancelservice.controller"})
@EnableEurekaClient
public class CancelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CancelServiceApplication.class, args);
	}

}

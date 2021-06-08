package com.flightbooking.checkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.flightbooking.checkinserver.controller"})
@EnableEurekaClient
public class CheckinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckinServerApplication.class, args);
	}

}

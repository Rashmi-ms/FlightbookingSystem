package com.flightbooking.checkfareserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.flightbooking.checkfareserver.controller"})
@EnableEurekaClient
public class CheckfareServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckfareServerApplication.class, args);
	}

}

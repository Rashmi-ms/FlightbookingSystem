package com.flightbooking.searchserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.flightbooking.searchserver.controller"})
@EnableEurekaClient
public class SearchServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchServerApplication.class, args);
	}

}

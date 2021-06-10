package com.flightbooking.adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.flightbooking.adminservice.service.AdminServiceImpl;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.flightbooking.adminservice.controller"})
@EnableEurekaClient
@EnableSwagger2
public class AdminServiceApplication {
	
	@Bean
	public AdminServiceImpl getAdminServiceImpl () {
		return new AdminServiceImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

}
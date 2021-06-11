package com.flightbookingsystem.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.flightbookingsystem.paymentservice.model.PaytmDetail;



@SpringBootApplication
public class PaymentServiceApplication {
	
	@Bean
	public PaytmDetail getpaymentdetails() {
		return new PaytmDetail();
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}

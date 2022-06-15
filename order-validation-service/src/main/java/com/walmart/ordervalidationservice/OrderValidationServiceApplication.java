package com.walmart.ordervalidationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderValidationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderValidationServiceApplication.class, args);
	}

}

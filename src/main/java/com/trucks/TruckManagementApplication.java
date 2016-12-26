package com.trucks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.controllers","com.models","com.services"})
public class TruckManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckManagementApplication.class, args);
	}
}

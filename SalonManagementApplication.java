package com.example.salon_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.controller")

public class SalonManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonManagementApplication.class, args);
	}

}

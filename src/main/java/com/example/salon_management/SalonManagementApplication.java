package com.example.salon_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.repository")
@EntityScan(basePackages = "com.example.model")
//@EntityScan("com.example.model")
@ComponentScan(basePackages = {"com.example.controller", "com.example.service", "com.example.repository"})
//basePackages: This is where you specify the list of packages that Spring should scan for components like @Component, @Service, @Repository, @Controller, and other Spring annotations.
public class SalonManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalonManagementApplication.class, args);
	}

}


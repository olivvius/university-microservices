package com.adressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.adressservice.controller", "com.adressservice.service"})
@EntityScan("com.adressservice.entity")
@EnableJpaRepositories("com.adressservice.repository")
@SpringBootApplication
@EnableDiscoveryClient
public class AdressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdressServiceApplication.class, args);
	}

}

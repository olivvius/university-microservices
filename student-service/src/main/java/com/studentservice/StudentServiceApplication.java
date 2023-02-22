package com.studentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableFeignClients("com.studentservice.feignclients")
@ComponentScan({"com.studentservice.controller", "com.studentservice.service"})
@EntityScan("com.studentservice.entity")
@EnableJpaRepositories("com.studentservice.repository")
@SpringBootApplication
@EnableDiscoveryClient

public class StudentServiceApplication {

	@Value("${address.service.url}")
	private String addressServiceUrl;


	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Bean
	public WebClient webClient (){
	WebClient webClient = WebClient.builder()
			.baseUrl(addressServiceUrl).build();
	return webClient;
	}


}

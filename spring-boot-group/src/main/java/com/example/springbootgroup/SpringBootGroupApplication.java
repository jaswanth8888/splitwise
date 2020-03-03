package com.example.springbootgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients("com.example.springbootgroup.service")
public class SpringBootGroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGroupApplication.class, args);
	}

}  

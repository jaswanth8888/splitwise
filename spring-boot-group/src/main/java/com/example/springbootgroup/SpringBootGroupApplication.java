package com.example.springbootgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootGroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGroupApplication.class, args);
	}

}

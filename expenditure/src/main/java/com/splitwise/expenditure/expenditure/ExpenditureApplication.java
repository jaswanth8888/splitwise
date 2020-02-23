package com.splitwise.expenditure.expenditure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class ExpenditureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenditureApplication.class, args);
	}

}

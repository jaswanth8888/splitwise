package com.splitwise.Splitwiseuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.splitwise.Splitwiseuser.Service")
public class SplitwiseUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseUserApplication.class, args);
	}

}

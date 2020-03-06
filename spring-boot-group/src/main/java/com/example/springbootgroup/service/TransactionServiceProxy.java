package com.example.springbootgroup.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@FeignClient(name="transaction-management")
public interface TransactionServiceProxy {
	
	 @GetMapping("transaction/{tId}")
	 public Object getTransaction(@PathVariable("tId") int tId); 
	
}

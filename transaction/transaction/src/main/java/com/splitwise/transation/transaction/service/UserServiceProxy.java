package com.splitwise.transation.transaction.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-management")
public interface UserServiceProxy {
	@GetMapping("/settle/{type}/{userId}/{amount}")
	public boolean addCredit(@PathVariable("type") String type,@PathVariable("userId") Integer userId,@PathVariable("amount") double amount );
}

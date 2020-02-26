package com.example.springbootgroup.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="splitwise-zuul")
public interface UserServiceProxy {
	 @GetMapping("user-management/user/{userId}")
	 public Object getUser(@PathVariable("userId") int userId); 
	 
	 @GetMapping("user-management/checkUser/{uId}")
	 public boolean checkUserExsists(@PathVariable("uId") int uId);
	}
	

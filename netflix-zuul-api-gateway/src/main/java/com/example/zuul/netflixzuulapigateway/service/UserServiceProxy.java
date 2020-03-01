package com.example.zuul.netflixzuulapigateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.ribbon.proxy.annotation.Http;

import org.springframework.security.core.userdetails.User;



@FeignClient(name="user-management")
public interface UserServiceProxy {
	 @GetMapping("/get-user-by-username/{userName}")
	 public HttpEntity<Object> getUserByUsername(@PathVariable("userName") String userName); 
	 
//	 @GetMapping("user-management/checkUser/{uId}")
//	 public boolean checkUserExsists(@PathVariable("uId") int uId);
}
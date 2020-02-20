package com.example.springbootgroup.service;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface GroupServiceProxy {


	 @GetMapping("/user/{userId}")
	    public HttpEntity<Object> getUser(@PathVariable("userId") int userId); 
	}

package com.example.springbootgroup.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="user-management")
public interface UserServiceProxy {
	 @GetMapping("user/{userId}")
	 public Object getUser(@PathVariable("userId") int userId); 
	 
	 @GetMapping("checkUser/{uId}")
	 public boolean checkUserExsists(@PathVariable("uId") int uId);
	 
	 @GetMapping("user/{userId}/group/{groupId}")
	public boolean addGroup(@PathVariable("userId") Integer userId,@PathVariable("groupId") Integer groupId);
}
	

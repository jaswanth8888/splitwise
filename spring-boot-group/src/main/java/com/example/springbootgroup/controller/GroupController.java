package com.example.springbootgroup.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootgroup.beans.Group;
import com.example.springbootgroup.service.GroupService;
import com.example.springbootgroup.service.UserServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class GroupController {


    
    @Autowired
    private GroupService groupService;
    
    @Autowired
    private UserServiceProxy userServiceProxy;
    
    @PostMapping("/create-group")
    public Group createGroup(@RequestBody Group group) {
    	System.out.println("group creation........");
//    	Group group1=new Group(1,"Fellas",101,Arrays.asList(),Arrays.asList(),Arrays.asList());
//    	
    	return groupService.createGroup(group);    	
    }
    @GetMapping("/get-group-name/{groupId}")
    public String getGroupName(@PathVariable Integer groupId) {
    	System.out.println(groupId);
    	return groupService.getGroupById(groupId).get().getName();
    }
    
    @GetMapping("/group/{groupId}")
    public Group getGroup(@PathVariable Integer groupId) {
    	return groupService.getGroupById(groupId).get();
    }
    
    /*@GetMapping("/group/users/{groupId}")
    public List<Object> getGroupUserDetails(@PathVariable Integer groupId){
    	Group g=groupService.getGroupById(groupId).get();
    	List<Object> users=new ArrayList<Object>();
    	for(Integer userId:g.getMembers()) {
    		users.add(userServiceProxy.getUser(userId));
    	}
    	return users;
    }*/
    
    
    
    @GetMapping("/group/users/{groupId}")
//    @HystrixCommand(fallbackMethod = "fallback")
    public List<Object> getGroupUserDetails(@PathVariable Integer groupId){
    	Group g=groupService.getGroupById(groupId).get();
    	List<Object> users=new ArrayList<Object>();
    	System.out.println("FallBack Method called ");
    	for(Integer userId:g.getMembers()) {
    		users.add(userServiceProxy.getUser(userId));
    	}
    	return users;
    }
    
    @SuppressWarnings("unused")
    private List<Object> fallback(Integer gid) {
        System.out.println("Breaking here");
        throw new RuntimeException("Hystrix");
        //List<Object> l=new ArrayList<Object>();
        //l.add(new Object());
        //return null;
    }
    
    

   /* @GetMapping("/group/users/{groupId}")
    public List<Object> getGroupWithEmployes
    */
    
	/*
	 * @GetMapping("/group/{groupId}") public Optional<Group> getGroup(@PathVariable
	 * Integer groupId) { return groupRepository.findById(groupId); }
	 * 
	 * @GetMapping("/check-group/{groupId}") public boolean
	 * checkGroupExsists(@PathVariable Integer groupId) { return
	 * groupRepository.existsById(groupId); }
	 */
    //add user
    //delete user
    
    
}


package com.example.springbootgroup.controller;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootgroup.beans.Group;
import com.example.springbootgroup.service.GroupService;





@RestController
public class GroupController {


//    @Autowired(required = true)
//    private GroupServiceProxy GroupServiceProxy;
    
    @Autowired
    private GroupService groupService;
    
    // here the group id logic is still not implemented, 
    // and the employee information will be taken from 
    // another micro service 
//    @GetMapping("/groups/{groupId}/{userId}")
//    public Object getGroupWithEmployees( @PathVariable int groupId, @PathVariable int userId) {
//        System.out.println("Requested Group ID " + groupId);
//        return GroupServiceProxy.getUser(userId);
//    } 
    
    //create
    
    @PostMapping("/create-group")
    public Group createGroup(@RequestBody Group group) {
    	System.out.println("group creation........");
    	Group group1=new Group(1,"Fellas",101,Arrays.asList(),Arrays.asList(),Arrays.asList());
    	
    	return groupService.createGroup(group1);    	
    }
    
    @GetMapping("/")
    public String hellowrold() {
    	return "hello-world";
    }
    
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


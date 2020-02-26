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





@RestController
public class GroupController {


    
    @Autowired
    private GroupService groupService;
    
    @Autowired
    private UserServiceProxy userServiceProxy;
    
    @PostMapping("/create-group")
    public Group createGroup(@RequestBody Group group) {
    	System.out.println("group creation........");
    	Group group1=new Group(1,"Fellas",101,Arrays.asList(),Arrays.asList(),Arrays.asList());
    	
    	return groupService.createGroup(group1);    	
    }
    
    @GetMapping("/group/{groupId}")
    public Group getGroup(@PathVariable Integer groupId) {
    	return groupService.getGroupById(groupId).get();
    }
    
    @GetMapping("/group/users/{groupId}")
    public List<Object> getGroupUserDetails(@PathVariable Integer groupId){
    	Group g=groupService.getGroupById(groupId).get();
    	List<Object> users=new ArrayList<Object>();
    	for(Integer userId:g.getMembers()) {
    		users.add(userServiceProxy.getUser(userId));
    	}
    	return users;
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


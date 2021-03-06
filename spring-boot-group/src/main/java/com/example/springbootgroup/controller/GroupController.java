package com.example.springbootgroup.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootgroup.beans.Group;
import com.example.springbootgroup.service.GroupService;
import com.example.springbootgroup.service.TransactionServiceProxy;
import com.example.springbootgroup.service.UserServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class GroupController {


    
    @Autowired
    private GroupService groupService;
    
    @Autowired
    private UserServiceProxy userServiceProxy;
    
    @Autowired
    private TransactionServiceProxy transactionServiceProxy;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create-group")
    public boolean createGroup(@RequestBody Group group) {
    	return groupService.createGroup(group) != null;    	
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
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/group/get-transactions/{groupId}")
    public List<Object> getGroupTransactions(@PathVariable Integer groupId){
    	List<Object> transactions=new ArrayList<Object>();
    Group group=groupService.getGroupById(groupId).get();
    for(Integer transactionId:group.getTransactions()) {
    	transactions.add(transactionServiceProxy.getTransaction(transactionId));
    }
    return transactions;
    }
    
//    @GetMapping("/group/users/{groupId}")
//    public List<Object> getGroupUserDetails(@PathVariable Integer groupId){
//    	Group g=groupService.getGroupById(groupId).get();
//    	List<Object> users=new ArrayList<Object>();
//    	for(Integer userId:g.getMembers()) {
//    		users.add(userServiceProxy.getUser(userId));
//    	}
//    	return users;
//    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add-transaction/{groupId}/{transactionId}")
    public Boolean addTransaction(@PathVariable Integer groupId,@PathVariable Integer transactionId) {
    	Group group = groupService.getGroupById(groupId).get();
    	List<Integer> transactions=group.getTransactions();
    	transactions.add(transactionId);
    	group.setTransactions(transactions);
    	 return groupService.save(group);
    	
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
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
    
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping("/group/{groupId}/add-user/{userId}")
    public boolean addUser(@PathVariable Integer groupId,@PathVariable Integer userId) {
    	Group g=groupService.getGroupById(groupId).get();
    	List<Integer> users=g.getMembers();
    	users.add(userId);
    	g.setMembers(users);
    	return groupService.save(g) && userServiceProxy.addGroup(userId,groupId);
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


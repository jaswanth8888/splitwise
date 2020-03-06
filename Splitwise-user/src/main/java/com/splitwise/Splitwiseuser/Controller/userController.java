package com.splitwise.Splitwiseuser.Controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.Splitwiseuser.Service.GroupServiceProxy;
import com.splitwise.Splitwiseuser.Service.userService;
import com.splitwise.Splitwiseuser.beans.Authenticate;
import com.splitwise.Splitwiseuser.beans.User;

@RestController
public class userController {
	@Autowired
	private userService userService;
	
	@Autowired
	private GroupServiceProxy groupServiceProxy;

	@GetMapping("/user/{uId}")
	public HashMap<Integer, String> getUser(@PathVariable int uId) {
		HashMap<Integer, String> user=new HashMap<Integer, String>();
		user.put(uId,userService.getUserById(uId).getName().getFirstName());
		return user;
	}
	@PostMapping("/user")
	public User saveUser(@RequestBody User user ) {
		return userService.insertUser(user);
	}

	@GetMapping("/checkUser/{uId}")
	public boolean CheckUser(@PathVariable int uId) {
		return userService.userExists(uId);
	}
	@PostMapping("/add-friend/{uId}/{friendId}")
	public boolean addfriend(@PathVariable int uId, @PathVariable int friendId) {
		return userService.addFriend(uId, friendId);
	}
	
	@GetMapping("/get-user-by-username/{username}")
	@CrossOrigin(origins = "http://localhost:3000")
	public HashMap<String, String> getUserByUsername(@PathVariable String username) {
		User user=userService.getUserByUsername(username);
		HashMap<String, String> userObject=new HashMap<String, String>();
		userObject.put("username", user.getEmail());
		userObject.put("password", user.getPassword());
		return userObject;
		
	}
	@GetMapping("/get-userId-by-username/{username}")
	@CrossOrigin(origins = "http://localhost:3000")
	public HashMap<String, String> getUserIdByUsername(@PathVariable String username) {
//		System.out.println(username);
		User user=userService.getUserByUsername(username);
		HashMap<String, String> userObject=new HashMap<String, String>();
		userObject.put("name", user.getName().getFirstName());
		userObject.put("id", String.valueOf(user.getId()));
		return userObject;
	}
	@GetMapping("/get-groups/{userId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public HashMap<Integer,String> getGroupsByUserId(@PathVariable Integer userId){
		User user=userService.getUserById(userId);
		List<Integer> groupIds=user.getGroups();
		HashMap<Integer,String> groups=new HashMap<Integer, String>();
		for(Integer groupId: groupIds) {
			 groups.put(groupId, groupServiceProxy.getGroupName(groupId));
		}
		return groups;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/authenticate")
	public HashMap<String,String> authenticate(@RequestBody Authenticate authenticate){
		HashMap<String, String> validation = new HashMap<String, String>();
		User user=userService.getUserByUsername(authenticate.getUsername());
		validation.put("email", authenticate.getUsername());
		validation.put("authentication",""+user.getPassword().equals(authenticate.getPassword()));
		
		return validation;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/get-user-transactions/{userId}")
	public HashMap<String, Object> getTransactionsAndCredit(@PathVariable Integer userId){
		User user=userService.getUserById(userId);
		HashMap<String, Object> transactionDetails=new HashMap<String, Object>();
		transactionDetails.put("credit",user.getCredit());
		transactionDetails.put("debit",user.getDebit());		
		return transactionDetails;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/get-all-users")
	public HashMap<Integer, String> getallUsers(){
		HashMap<Integer, String> users=new HashMap<Integer, String>();
		List<User> userz=userService.getAllUsers();
		for(User user:userz) {
			users.put(user.getId(), user.getName().getFirstName());
		}
		return users;
	}
	
	@GetMapping("/settle/{type}/{userId}/{amount}")
	public boolean settleCreditdebit(@PathVariable String type,@PathVariable Integer userId,@PathVariable Integer amount) {
		User u=userService.getUserById(userId);
		if(type.equals("debit")) {
			Integer due=u.getDebit();
			u.setDebit(due-amount);
			return userService.save(u);
		}
		Integer credit=u.getCredit();
			u.setCredit(credit+amount);
		return userService.save(u);
	}
	@CrossOrigin("http://localhost:3000")
	@GetMapping("user/{userId}/group/{groupId}")
	public boolean addGroup(@PathVariable Integer userId,@PathVariable Integer groupId) {
		System.out.println("add group"+userId+" "+groupId);
		User u=userService.getUserById(userId);
		List<Integer> groups=u.getGroups();
		groups.add(groupId);
		return userService.save(u);
	}
}

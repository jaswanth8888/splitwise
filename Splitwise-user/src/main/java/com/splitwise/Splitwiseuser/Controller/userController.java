package com.splitwise.Splitwiseuser.Controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.Splitwiseuser.Service.GroupServiceProxy;
import com.splitwise.Splitwiseuser.Service.userService;
import com.splitwise.Splitwiseuser.beans.User;

@RestController
public class userController {
	@Autowired
	private userService userService;
	
	@Autowired
	private GroupServiceProxy groupServiceProxy;

	@GetMapping("/user/{uId}")
	public User getUser(@PathVariable int uId) {
		return userService.getUserById(uId);
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
		System.out.println(userId);
		User user=userService.getUserById(userId);
		List<Integer> groupIds=user.getGroups();
		HashMap<Integer,String> groups=new HashMap<Integer, String>();
		System.out.println(groupServiceProxy.getGroupName(1));
		for(Integer groupId: groupIds) {
			 groups.put(groupId, groupServiceProxy.getGroupName(groupId));
		}
		return groups;
	}
	
}

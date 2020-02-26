package com.splitwise.Splitwiseuser.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.Splitwiseuser.Service.userService;
import com.splitwise.Splitwiseuser.beans.User;

@RestController
public class userController {
	@Autowired
	private userService userService;

	@GetMapping("/user/{uId}")
	public User getUser(@PathVariable int uId) {
		User user = userService.getUserById(uId);
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
}

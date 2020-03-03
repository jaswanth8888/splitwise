package com.splitwise.Splitwiseuser.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitwise.Splitwiseuser.Repository.UserRepository;
import com.splitwise.Splitwiseuser.beans.User;

@Service
public class userService {
	@Autowired
	private UserRepository userRepository;

	public User getUserById(Integer uId) {
		if(userRepository.existsById(uId)){
			return userRepository.findById(uId).get();
		}
		return null;
	}

	public User insertUser(User user) {
		return userRepository.insert(user);
	}

	public boolean userExists(Integer uId) {
		return userRepository.existsById(uId);
	}

	public void deleteEmployee(Integer uId) {
		userRepository.deleteById(uId);
	}

	public boolean addFriend(Integer uId, Integer friendId)

	{
		if (this.userExists(friendId)) {
			User user = this.getUserById(uId);			
			List<Integer> friends = user.getFriends();
			friends.add(friendId);
			user.setFriends(friends);
			return userRepository.save(user) != null;

		}
		return false;
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}
}

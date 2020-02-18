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

	public Optional<User> getUserById(Integer uId) {
		return userRepository.findById(uId);
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
			Optional<User> user = this.getUserById(uId);
			User user1 = user.get();
			List<Integer> friends = user1.getFriends();
			friends.add(friendId);
			user1.setFriends(friends);
			return userRepository.save(user1) != null;

		}
		return false;
	}
}

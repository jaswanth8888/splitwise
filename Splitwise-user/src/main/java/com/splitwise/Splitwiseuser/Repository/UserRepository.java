package com.splitwise.Splitwiseuser.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.splitwise.Splitwiseuser.beans.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	
		@Query(value="{'email':?0}")
		User findByUsername(String username); 
}

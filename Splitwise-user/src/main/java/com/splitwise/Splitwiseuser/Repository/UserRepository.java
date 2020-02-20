package com.splitwise.Splitwiseuser.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.splitwise.Splitwiseuser.beans.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	
}

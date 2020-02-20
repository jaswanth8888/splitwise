package com.example.springbootgroup.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootgroup.beans.Group;

public interface GroupRepository extends MongoRepository<Group, Integer> {



}

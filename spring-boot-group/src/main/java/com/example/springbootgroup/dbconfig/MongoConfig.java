package com.example.springbootgroup.dbconfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.springbootgroup.repo.GroupRepository;


@Configuration
@EnableMongoRepositories(basePackageClasses = GroupRepository.class)
public class MongoConfig {
	

}

package com.splitwise.transation.transaction.dbconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.splitwise.transation.transaction.Repository.TransactionRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = TransactionRepository.class)
public class MongoConfig {

}

package com.splitwise.expenditure.expenditure.dbConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.splitwise.expenditure.expenditure.Repository.ExpenditureRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = ExpenditureRepository.class)
public class MongoConfig {

}

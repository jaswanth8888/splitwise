package com.splitwise.expenditure.expenditure.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.splitwise.expenditure.expenditure.beans.Expenditure;

public interface ExpenditureRepository  extends MongoRepository<Expenditure, Integer>{

}

package com.splitwise.transation.transaction.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.splitwise.transation.transaction.beans.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {

}

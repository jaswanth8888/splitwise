package com.splitwise.transation.transaction.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.splitwise.transation.transaction.beans.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {
	@Query(value="{$and:[{isSettled:false}, {fromUser:?0}]}")
	List<Transaction> getTransactionsfromUser(Integer userId);
	
	@Query(value="{$and:[{isSettled:false}, { toUser: ?0 }]}")
	List<Transaction> getTransactionstoUser(Integer userId);
}

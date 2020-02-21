package com.splitwise.transation.transaction.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitwise.transation.transaction.Repository.TransactionRepository;
import com.splitwise.transation.transaction.beans.Transaction;

@Service
public class Transactionservice {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.insert(transaction);
	}
	
	public Optional<Transaction> getTransactionbyId(Integer transactionId) {
		return transactionRepository.findById(transactionId);
	}
	
	public boolean checkTransaction(Integer transactionId) {
		return transactionRepository.existsById(transactionId);
	}
}

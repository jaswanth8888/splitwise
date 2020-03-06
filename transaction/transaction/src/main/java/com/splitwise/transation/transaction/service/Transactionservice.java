package com.splitwise.transation.transaction.service;

import java.util.List;
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
	public List<Transaction> getTransactionsfromUser(Integer userId){
		return transactionRepository.getTransactionsfromUser(userId);
	}
	public List<Transaction> getTransactionstoUser(Integer userId){
		return transactionRepository.getTransactionstoUser(userId);
	}

	public boolean save(Transaction t) {
		// TODO Auto-generated method stub
		return transactionRepository.save(t)!=null;
	}
}

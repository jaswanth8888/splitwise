package com.splitwise.transation.transaction.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.transation.transaction.beans.Transaction;
import com.splitwise.transation.transaction.service.Transactionservice;

@RestController
public class TransactionController {
	@Autowired
	private Transactionservice transactionservice;
	
	@GetMapping("/transaction/{tId}")
	public Transaction getTransactionById(@PathVariable Integer tId) {
		if(transactionservice.checkTransaction(tId)) {
		 Optional<Transaction> OTransaction=transactionservice.getTransactionbyId(tId);
		 Transaction transaction=OTransaction.get();
		 return transaction;
		}
		
		return null;
	}
	
	@PostMapping("/transaction")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return transactionservice.createTransaction(transaction);
	}	
}

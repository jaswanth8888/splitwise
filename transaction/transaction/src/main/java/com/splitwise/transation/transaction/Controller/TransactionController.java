package com.splitwise.transation.transaction.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.transation.transaction.beans.Transaction;
import com.splitwise.transation.transaction.service.GroupServiceProxy;
import com.splitwise.transation.transaction.service.Transactionservice;
import com.splitwise.transation.transaction.service.UserServiceProxy;

@RestController
public class TransactionController {
	@Autowired
	private Transactionservice transactionservice;
	
//	@Autowired
//	private GroupServiceProxy groupServiceProxy;
	
	@Autowired(required=true)
	private UserServiceProxy userServiceProxy;
	
	@GetMapping("/transaction/{tId}")
	public Transaction getTransactionById(@PathVariable Integer tId) {
		if(transactionservice.checkTransaction(tId)) {
		 Optional<Transaction> OTransaction=transactionservice.getTransactionbyId(tId);
		 Transaction transaction=OTransaction.get();
		 return transaction;
		}
		
		return null;
	}
	
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/group/transaction")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		
		return transactionservice.createTransaction(transaction);
		
	}
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/user/{userId}")
	public List<Transaction> getTransactionsOfUser(@PathVariable Integer userId){
		System.out.println(userId);
		List<Transaction> t=new ArrayList<Transaction>();
		t.addAll(transactionservice.getTransactionsfromUser(userId));
		t.addAll(transactionservice.getTransactionstoUser(userId));
		return t;
	}
	
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/settle-transaction/{tId}") 
	public boolean settleTransaction(@PathVariable Integer tId) {
		Transaction t=transactionservice.getTransactionbyId(tId).get();
		t.setSettled(true);
		return transactionservice.save(t);
		
	}
	
}

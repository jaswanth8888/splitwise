package com.splitwise.Splitwiseuser.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="transaction-management")
public interface TransactionServiceProxy {
	
	@GetMapping("/user/{userId}")
	public List<Object> getUserTransactions(@PathVariable("userId") Integer userId);
}

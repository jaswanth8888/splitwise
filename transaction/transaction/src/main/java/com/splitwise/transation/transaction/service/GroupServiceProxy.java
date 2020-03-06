package com.splitwise.transation.transaction.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="group-management")
public interface GroupServiceProxy {
	@GetMapping("/add-transaction/{groupId}/{transactionId}")
	 public boolean addTransaction(@PathVariable("groupId") Integer groupId,@PathVariable("transactionId") Integer transactionId);
}
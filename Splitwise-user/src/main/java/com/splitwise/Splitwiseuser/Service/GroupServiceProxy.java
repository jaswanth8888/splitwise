package com.splitwise.Splitwiseuser.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="group-management")
public interface GroupServiceProxy {
	@GetMapping("/get-group-name/{groupId}")
	 public String getGroupName(@PathVariable("groupId") Integer userId);
}

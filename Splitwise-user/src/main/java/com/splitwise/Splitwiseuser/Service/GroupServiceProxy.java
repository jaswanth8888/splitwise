package com.splitwise.Splitwiseuser.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="splitwise-zuul")
public interface GroupServiceProxy {
	@GetMapping("group-management/get-group-name/{groupId}")
	 public String getGroupName(@PathVariable("groupId") Integer userId);
}

package com.example.springbootgroup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootgroup.beans.Group;
import com.example.springbootgroup.repo.GroupRepository;

@Service
public class GroupService {
	@Autowired
	private GroupRepository groupRepository;

	public Group createGroup(Group group) {
		return groupRepository.insert(group);
	}
	
	public Optional<Group> getGroupById(Integer groupId) {
		return groupRepository.findById(groupId);
	}
	
	public boolean checkGroupExsists(Integer groupId) {
		return groupRepository.existsById(groupId);
	}
	
	public boolean save(Group group) {
		return groupRepository.save(group) != null;
	}
}

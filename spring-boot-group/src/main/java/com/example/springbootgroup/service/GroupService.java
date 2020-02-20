package com.example.springbootgroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootgroup.beans.Group;
import com.example.springbootgroup.repo.GroupRepository;

@Service
	public class GroupService {
		@Autowired
		private GroupRepository groupRepository;
		
		public Group createGroup(Group group){
			return groupRepository.insert(group);
		}

	
		}


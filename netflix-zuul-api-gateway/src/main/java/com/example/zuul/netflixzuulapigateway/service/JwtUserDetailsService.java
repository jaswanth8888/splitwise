package com.example.zuul.netflixzuulapigateway.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.zuul.netflixzuulapigateway.model.JwtRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired(required=true)
	private UserServiceProxy userServiceProxy;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ObjectMapper objectMapper=new ObjectMapper();
		JwtRequest user=objectMapper.convertValue(userServiceProxy.getUserByUsername(username).getBody(), JwtRequest.class);
		if (user!=null) {
			return new User(user.getUsername(), user.getPassword(),new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
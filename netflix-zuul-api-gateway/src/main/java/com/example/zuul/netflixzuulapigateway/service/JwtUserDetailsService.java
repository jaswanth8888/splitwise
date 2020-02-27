package com.example.zuul.netflixzuulapigateway.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired(required=true)
	private UserServiceProxy userServiceProxy;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Object user=userServiceProxy.getUserByUsername(username);
		if (user!=null) {
			return new User("jaswanth@ps.com", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
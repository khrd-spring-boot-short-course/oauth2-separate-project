package com.phearun.configuration.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		User user = null;
		if (username.equals("user"))
			user = new com.phearun.configuration.security.User(username, "user", "USER");
		else if (username.equals("admin"))
			user = new com.phearun.configuration.security.User(username, "admin", "ADMIN");

		return new CustomUserDetail(user);
	}

}

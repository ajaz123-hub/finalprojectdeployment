package com.digitalbooks.authorservice.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// find user from database where user = :username
// userRepo.findByUsername(username);// username, password, roles

		if ("author".equals(username)) {
					
			return new User(
					"author", 
					"{noop}author@123", 
//					"$2a$10$ImVA6b1HFYDKA0766fhmTe7CKdyPVfgXe77.rRjRFuzx/6f4v/TDO",
					new ArrayList<>());
		}  else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
//
	}

}

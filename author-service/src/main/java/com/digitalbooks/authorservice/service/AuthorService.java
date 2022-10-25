package com.digitalbooks.authorservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.digitalbooks.authorservice.constant.ResponseConstants;
import com.digitalbooks.authorservice.model.AuthorDetails;
import com.digitalbooks.authorservice.model.BaseResponse;
import com.digitalbooks.authorservice.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepo;
	
	public AuthorDetails save(AuthorDetails author) {
		
        return authorRepo.save(author);
		

	}
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthorDetails user =  authorRepo.findByUserName(username);
        String pwd=user.getPassword();
        System.out.println(pwd +" password");
        if(user.getUsername().equals(username)) {
            System.out.println(username);
            System.out.println(user.getUsername());
            System.out.println(user.getUsername().equals(username));
            
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList());
        } else {
            System.out.println("not logged in");
            System.out.println(username);
            System.out.println(user);
            System.out.println(user.getUsername());
            throw new UsernameNotFoundException("User not present");
        }
        }

	public String validateUser(String username, String password) {
		String dbPassword = authorRepo.filterByPassword(username);
		if (dbPassword != null) {
			if (dbPassword.equals(password)) {
				return "success";
			} else {
				return "failure";
			}
		} else {
			return "false";
		}

	}
	
	

	public List<AuthorDetails> getAuthors() {
		// TODO Auto-generated method stub
		return authorRepo.findAll();
	}
	
	
	public Optional<AuthorDetails> getAuthorById(int aId) {
		return authorRepo.findById(aId);

	}

	public Optional<AuthorDetails> getAuthorByName(String username) {

		return authorRepo.findByName(username);
	}


}

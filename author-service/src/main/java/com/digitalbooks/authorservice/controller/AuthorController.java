package com.digitalbooks.authorservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.authorservice.clients.BookServiceClient;

import com.digitalbooks.authorservice.model.AuthorDetails;
import com.digitalbooks.authorservice.model.BaseResponse;
import com.digitalbooks.authorservice.model.BookEntity;
import com.digitalbooks.authorservice.model.JwtRequest;
import com.digitalbooks.authorservice.model.JwtResponse;
import com.digitalbooks.authorservice.service.AuthorService;
import com.digitalbooks.authorservice.util.JwtTokenUtil;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/digitalbooks/author")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {

	@Autowired
	private BookServiceClient bookServiceClient;
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	AuthorService authorService;
	

	@PostMapping("/signup")
	public ResponseEntity<?> saveCredentials(@RequestBody AuthorDetails signUpRequest) {

		AuthorDetails author = new AuthorDetails();
	        author.setUsername(signUpRequest.getUsername());
	        author.setPassword(signUpRequest.getPassword());
	        author.setAuthorEmailId(signUpRequest.getAuthorEmailId());
	        authorService.save(author);
	        return ResponseEntity.ok(new JwtResponse("User registered successfully"));
	}
	
	
	
	@GetMapping()
	public List<AuthorDetails> getAuthorDetails() {
		return authorService.getAuthors();
	}
	

	
       
	@PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest req) {
		System.out.println("THE REQUEST:"+req);
        System.out.println("authenticated in");
        authenticate(req.getUsername(), req.getPassword());//call if login is success
        System.out.println("THE REQUEST-2:"+req);
        UserDetails userDetails = authorService.loadUserByUsername(req.getUsername());
        System.out.println("THE REQUEST-3:"+userDetails);
        System.out.println(userDetails.isEnabled());
        System.out.println("authenticated successfully");
        System.out.println("user details :------" + userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }



   private void authenticate(String username, String password) {
        System.out.println("userName" + username +"password :" + password);
        try {
            System.out.println("authenticated in");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("userName" + username +"password :" + password);
        } catch (DisabledException e) {
           
        } catch (BadCredentialsException e) {
           
        }
    }

   @PostMapping("{authorId}/books") 
	 public BookEntity saveBook(@PathVariable int authorId,@RequestBody BookEntity book) {
		 book.setAuthorId(authorId);
		 return bookServiceClient.SaveBook(book); 
		 
	 }
   
     @PutMapping("{authorId}/books/{bookId}") 
	 public BookEntity updateBook(@PathVariable int authorId,@PathVariable int bookId,@RequestBody BookEntity book) {
		 book.setAuthorId(authorId);
		 book.setBookId(bookId);
		 return bookServiceClient.updateBook(book); 
		 
	 }
	
	@GetMapping("/getAuthor/{aId}")
	public Optional<AuthorDetails> getAuthorByID(@PathVariable int aId) {
		return authorService.getAuthorById(aId);
	}
	
	@GetMapping("/getAuthorByName/{authorName}")
	public Optional<AuthorDetails> getAuthorByName(@PathVariable String username){
		return authorService.getAuthorByName(username);
	}
	

}

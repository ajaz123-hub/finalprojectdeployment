package com.digitalbooks.authorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.authorservice.model.JwtRequest;
import com.digitalbooks.authorservice.model.JwtResponse;
import com.digitalbooks.authorservice.service.JwtUserDetailsService;
import com.digitalbooks.authorservice.util.JwtTokenUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping("/api/v1/digitalbooks/author/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody JwtRequest req) throws Exception {
		authenticate(req.getUsername(), req.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println(token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}

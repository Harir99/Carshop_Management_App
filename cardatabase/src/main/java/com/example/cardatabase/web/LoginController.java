package com.example.cardatabase.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardatabase.domain.AccountCredentials;
import com.example.cardatabase.service.JwtService;

@RestController
public class LoginController {
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
	public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
		UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password());
		Authentication auth = authenticationManager.authenticate(creds);
		
		// Generate token
		String jwts = jwtService.getToken(auth.getName());
		
		// Build response with the generated token
		return ResponseEntity.ok()  // Return 200 OK with JWT in headers
		    .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts) // JWT token for client auth, "Bearer" = standard prefix 
		    .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization") // allow JS to read it
		    .build();
	}
}
package com.example.cardatabase;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.
 AuthenticationException;
import org.springframework.security.web.
 AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized: client tried accessing a protected resource without valid credentials
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); // Response will be JSON so the client can parse it
		PrintWriter writer = response.getWriter(); 
		writer.println("Error: " + authException.getMessage()); // Send back a simple error message explaining why authentication failed
	}	
}

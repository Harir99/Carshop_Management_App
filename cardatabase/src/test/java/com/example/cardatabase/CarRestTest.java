package com.example.cardatabase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest // Start full Spring application context for testing
@AutoConfigureMockMvc // Automatically configure MockMvc for testing controllers
class CarRestTest {

   @Autowired
   private MockMvc mockMvc; // Inject MockMvc to simulate HTTP requests

   @Test
   public void testAuthentication() throws Exception {
       // Simulate POST request to /login endpoint with JSON credentials
       this.mockMvc
           .perform(post("/login")
               .content("{\"username\":\"admin\",\"password\":\"admin\"}") // Request body with login credentials
               .header(HttpHeaders.CONTENT_TYPE,"application/json")) // Set Content-Type to application/json
           .andDo(print()) // Print request and response details to console
           .andExpect(status().isOk()); // Assert that response status is 200 OK
   }
}

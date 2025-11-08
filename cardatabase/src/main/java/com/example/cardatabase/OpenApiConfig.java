package com.example.cardatabase;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import io.swagger.v3.oas.models.OpenAPI;
 import io.swagger.v3.oas.models.info.Info;
 
 @Configuration
 public class OpenApiConfig {

  /*
     * Provides metadata for Swagger / OpenAPI documentation.
     * - The title, description, and version appear in Swagger UI.
     * - Enables developers to explore and test REST endpoints interactively.
     * - Helps maintain API documentation as the project evolves.
     */
     @Bean
     public OpenAPI carDatabaseOpenAPI() {
         return new OpenAPI().info(
             new Info()
                 .title("Car REST API")       
                 .description("My car stock") 
                 .version("1.0")             
         );
     }
 }
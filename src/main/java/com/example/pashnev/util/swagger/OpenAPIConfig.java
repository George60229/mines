package com.example.pashnev.util.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
      return new OpenAPI().components(new Components()).info(new Info().title("Bombs CRUD API")
              .description("Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
              .version("v0.0.1"));
    }
}

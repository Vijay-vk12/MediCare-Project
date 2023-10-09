package com.example.demo.configure;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition     // class level annottion open api
@Configuration
public class SwaggerConfig {

	
	public OpenAPI baseSwaggerApi()
	{
		return new OpenAPI().info(new Info().title("MediCare").version("1.0.0").description("MediCare of Medicine"));
	}
}

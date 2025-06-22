package com.soumya.student_db.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
    
    @Bean
    public OpenAPI swaggerConfig(){
        return new OpenAPI().info(
            new Info().title("Student API").description("Student API Made By Soumya")
        );
    }
}

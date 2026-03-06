package com.example.student_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

// Source - https://stackoverflow.com/q/79626449
// Posted by CodeSage
// Retrieved 2026-03-05, License - CC BY-SA 4.0

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Customer Feedback SaaS API")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Ajoy Deb Nath")
                                .email("sample@gmail.com")));
    }
}

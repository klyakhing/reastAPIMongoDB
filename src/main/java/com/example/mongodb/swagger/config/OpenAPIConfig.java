package com.example.mongodb.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${demo.openapi.dev-url}")
    private String devUrl;

    @Value("${demo.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("klyakhin@yahoo.com");
        contact.setName("George Klyakhin");




        Info info = new Info()
                .title("REST API Example with MongoDB")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials.");


        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}

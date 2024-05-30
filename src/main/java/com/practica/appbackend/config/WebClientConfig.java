package com.practica.appbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${ms.task.url}")
    private String msTaskCustomer;

    @Bean("taskWebClient")
    public WebClient taskWebClient() {
        return WebClient.create(msTaskCustomer+"/api/task");
    }
}

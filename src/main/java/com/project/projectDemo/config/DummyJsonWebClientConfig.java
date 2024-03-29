package com.project.projectDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DummyJsonWebClientConfig {

    @Bean
    public WebClient dummyJsonWebClient() {
        return WebClient.builder()
                .baseUrl("https://dummyjson.com/")
                .build();
    }

}

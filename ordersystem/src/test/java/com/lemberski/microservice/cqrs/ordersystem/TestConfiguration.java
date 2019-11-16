package com.lemberski.microservice.cqrs.ordersystem;

import com.github.javafaker.Faker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }

}
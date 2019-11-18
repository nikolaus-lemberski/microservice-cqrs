package com.lemberski.microservice.cqrs.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableJdbcRepositories
//@Configuration
@EnableRabbit
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	@Bean
	public OrderReceiver receiver() {
		return new OrderReceiver();
	}
	*/

}

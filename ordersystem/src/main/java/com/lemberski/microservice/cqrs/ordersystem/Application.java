package com.lemberski.microservice.cqrs.ordersystem;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJdbcRepositories
@EnableJdbcAuditing
@EnableAsync
@Configuration
public class Application {

	static final String ORDER_QUEUE = "orderQueue";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Queue orderQueue() {
		return new Queue(ORDER_QUEUE, true);
	}

}

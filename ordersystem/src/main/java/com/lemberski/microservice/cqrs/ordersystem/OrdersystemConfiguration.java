package com.lemberski.microservice.cqrs.ordersystem;

import com.lemberski.microservice.cqrs.shared.OrderMessage;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@Profile("cloud")
public class OrdersystemConfiguration {

    @Bean
    public Queue orderQueue() {
        return new Queue(OrderMessage.QUEUE, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(OrderMessage.TOPIC);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("cqrx.orders.#");
    }

}

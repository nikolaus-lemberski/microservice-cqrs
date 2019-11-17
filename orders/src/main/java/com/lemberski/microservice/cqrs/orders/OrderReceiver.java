package com.lemberski.microservice.cqrs.orders;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RabbitListener(queues = "orderQueue")
public class OrderReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(OrderReceiver.class);

    @RabbitHandler
    public void listen(String message) {
        LOG.info("Message read from orderQueue : {}", message);
    }

}
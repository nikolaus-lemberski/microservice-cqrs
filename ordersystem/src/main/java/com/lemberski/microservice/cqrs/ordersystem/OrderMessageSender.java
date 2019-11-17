package com.lemberski.microservice.cqrs.ordersystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageSender {

    private static final Logger LOG = LoggerFactory.getLogger(OrderMessageSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Async
    public void sendMessage(Order order) {
        LOG.info("Send message: {}", order);
        rabbitTemplate.convertAndSend(Application.ORDER_QUEUE, String.format("Order with ID %s received.", order.getId()));
        LOG.info("Message sent");
    }

}
package com.lemberski.microservice.cqrs.ordersystem;

import com.lemberski.microservice.cqrs.shared.OrderMessage;

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
        OrderMessage orderMessage = new OrderMessage();
        orderMessage.setId(order.getId());
        orderMessage.setUserId(order.getUserId());
        orderMessage.setOrderDate(order.getCreatedDate());
        Double totalPrice = order.getProducts().stream().mapToDouble(p -> p.getPrice()).sum();
        orderMessage.setTotalPrice(totalPrice);
        orderMessage.setStatus("OPEN");
        LOG.info("Send message: {}", orderMessage);
        rabbitTemplate.convertAndSend(Application.ORDER_QUEUE, orderMessage);
    }

}
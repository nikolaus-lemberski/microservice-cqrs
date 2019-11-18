package com.lemberski.microservice.cqrs.ordersystem;

import com.lemberski.microservice.cqrs.shared.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Profile("cloud")
public class OrderMessageSenderImpl implements OrderMessageSender {

    private static final Logger LOG = LoggerFactory.getLogger(OrderMessageSenderImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    @Async
    public void sendMessage(Order order) {
        OrderMessage orderMessage = new OrderMessage();
        orderMessage.setOrderId(order.getId());
        orderMessage.setUserId(order.getUserId());
        orderMessage.setOrderDate(order.getCreatedDate());
        Double totalPrice = order.getProducts().stream().mapToDouble(p -> p.getPrice()).sum();
        orderMessage.setTotalPrice(totalPrice);
        orderMessage.setStatus("OPEN");
        LOG.info("Send message: {}", orderMessage);
        rabbitTemplate.convertAndSend(OrderMessage.TOPIC, "cqrx.orders.order", orderMessage);
    }

}
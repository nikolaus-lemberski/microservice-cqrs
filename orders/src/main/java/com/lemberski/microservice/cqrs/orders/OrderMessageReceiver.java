package com.lemberski.microservice.cqrs.orders;

import com.lemberski.microservice.cqrs.shared.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(OrderMessageReceiver.class);

    @RabbitListener(queues = "orderQueue")
    public void listen(OrderMessage orderMessage) {
        LOG.info("Message read from orderQueue : {}", orderMessage);
    }

}
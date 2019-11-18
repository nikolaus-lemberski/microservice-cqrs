package com.lemberski.microservice.cqrs.orders;

import com.lemberski.microservice.cqrs.shared.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(OrderMessageReceiver.class);

    @Autowired
    private OrderRepository orderRepository;

    @RabbitListener(queues = "orderQueue")
    public void listen(OrderMessage orderMessage) {
        LOG.debug("Message read from orderQueue : {}", orderMessage);

        Order order = new Order();
        BeanUtils.copyProperties(orderMessage, order);
        if (!orderRepository.findById(order.getId()).isPresent()) {
            orderRepository.save(order);
            LOG.debug("Order with properties {} saved.", order);
        }
    }

}
package com.lemberski.microservice.cqrs.orders;

import com.lemberski.microservice.cqrs.shared.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(OrderMessageReceiver.class);

    @Autowired
    private OrderRepository orderRepository;

    public void receive(OrderMessage orderMessage) {
        LOG.info("Message read from orderQueue : {}", orderMessage);

        Order order = new Order();
        BeanUtils.copyProperties(orderMessage, order);
        if (!orderRepository.findByOrderId(order.getOrderId()).iterator().hasNext()) {
            orderRepository.save(order);
            LOG.info("Order with properties {} saved.", order);
        }
    }

}
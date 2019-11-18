package com.lemberski.microservice.cqrs.ordersystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMessageSender orderMessageSender;

    @PostMapping
    @Transactional
    public Order placeOrder(@RequestBody Order order) {
        Order persisted = orderRepository.save(order);
        persisted.setProducts(persisted.getProducts().stream().distinct().collect(Collectors.toSet()));
        orderMessageSender.sendMessage(persisted);
        return persisted;
    }

}
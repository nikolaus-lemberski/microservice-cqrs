package com.lemberski.microservice.cqrs.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{userId}")
    public Iterable<Order> myOrders(@PathVariable String userId) {
        return orderRepository.findByUserId(userId);
    }

}
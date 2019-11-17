package com.lemberski.microservice.cqrs.myorders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{userId}")
    public Iterable<Order> myOrders(@PathVariable String userId) {
        return orderRepository.findByUserId(userId);
    }

}
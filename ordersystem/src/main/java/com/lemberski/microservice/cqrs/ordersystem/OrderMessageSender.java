package com.lemberski.microservice.cqrs.ordersystem;

import org.springframework.scheduling.annotation.Async;

public interface OrderMessageSender {
    @Async
    void sendMessage(Order order);
}

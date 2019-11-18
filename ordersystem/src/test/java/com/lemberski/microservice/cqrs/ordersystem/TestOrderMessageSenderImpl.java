package com.lemberski.microservice.cqrs.ordersystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestOrderMessageSenderImpl implements OrderMessageSender {

    private static final Logger LOG = LoggerFactory.getLogger(TestOrderMessageSenderImpl.class);

    @Override
    public void sendMessage(Order order) {
        LOG.info("TEST ENVIRONMENT - sending Order message {}", order);
    }

}

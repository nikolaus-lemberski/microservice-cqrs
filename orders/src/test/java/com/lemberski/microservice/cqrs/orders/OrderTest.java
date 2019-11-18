package com.lemberski.microservice.cqrs.orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class OrderTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testCreate() {
        assertThat(orderRepository.count()).isEqualTo(0L);

        Order order = new Order();
        order.setOrderId(123L);
        order.setUserId("user-1");
        order.setOrderDate(new Date());
        order.setTotalPrice(10.11);
        orderRepository.save(order);

        assertThat(orderRepository.findByOrderId(123L)).isNotEmpty();
    }

    @Test
    public void testFindByUserId() {
        assertThat(orderRepository.count()).isEqualTo(0L);

        Order order = new Order();
        order.setOrderId(123L);
        order.setUserId("user-1");
        order.setOrderDate(new Date());
        order.setTotalPrice(10.11);
        orderRepository.save(order);

        assertThat(orderRepository.findByUserId("user-1")).isNotEmpty();
    }

}
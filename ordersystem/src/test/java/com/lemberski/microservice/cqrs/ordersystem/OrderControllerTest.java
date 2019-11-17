package com.lemberski.microservice.cqrs.ordersystem;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testPlaceOrder() throws Exception {
        assertThat(orderRepository.count()).isEqualTo(0L);

        mockMvc.perform(post("/")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{"
                + "\"userId\": \"user-1\","
                + "\"address\": {"
                    + "\"firstName\": \"Vorname\","
                    + "\"lastName\": \"Nachname\""                
                + "},"
                + "\"products\": ["
                    + "{"
                        + "\"sku\": \"sku1\","
                        + "\"title\": \"Product Title\","
                        + "\"description\": \"Product description\""
                    + "}"
                + "]"
            + "}"))
            .andExpect(status().is(200));

        assertThat(orderRepository.count()).isEqualTo(1L);
        Order order = orderRepository.findAll().iterator().next();
        assertThat(order.getUserId()).isEqualTo("user-1");
        assertThat(order.getAddress().getFirstName()).isEqualTo("Vorname");
        assertThat(order.getAddress().getLastName()).isEqualTo("Nachname");
        assertThat(order.getProducts()).isNotEmpty();
    }

}
package com.lemberski.microservice.cqrs.ordersystem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class OrderTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Faker faker;

    @Test
    public void test() {
        assertThat(orderRepository.count()).isEqualTo(0L);
        assertThat(productRepository.count()).isEqualTo(0L);

        Address address = new Address();
        address.setFirstName(faker.name().firstName());
        address.setLastName(faker.name().lastName());
        address.setStreet(faker.address().streetName());
        address.setZip(faker.address().zipCode());
        address.setCity(faker.address().city());
        address.setCountry(faker.address().country());

        Product product = new Product();
        product.setSku(faker.code().ean13());
        product.setTitle(faker.commerce().productName());
        product.setDescription(faker.hitchhikersGuideToTheGalaxy().marvinQuote());
        product.setPrice(10.99);

        Order order = new Order();
        order.setUserId(faker.code().ean8());
        order.setAddress(address);
        order.addProduct(product);
        orderRepository.save(order);

        assertThat(orderRepository.count()).isEqualTo(1L);
        assertThat(productRepository.count()).isEqualTo(1L);
    }

}
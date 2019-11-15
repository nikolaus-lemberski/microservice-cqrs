package com.lemberski.microservice.cqrs.ordersystem;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void test() {
        Address address = new Address();
        address.setFirstName("Firstname");
        address.setLastName("Lastname");
        address.setStreet("Street 1");
        address.setZip("12345");
        address.setCity("City");

        Product product = new Product();
        product.setSku("123ABC");
        product.setTitle("Product 1");
        product.setDescription("Product 1 description");
        product.setPrice(10.99);
     
        Order order = new Order();
        order.setUserId("user1");
        order.setAddress(address);
        order.addProduct(product);
        
        entityManager.persist(order);
        entityManager.flush();

        //assertThat(orderRepository.findByUserId("user1"), is(true));
    }

}
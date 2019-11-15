package com.lemberski.microservice.cqrs.ordersystem;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
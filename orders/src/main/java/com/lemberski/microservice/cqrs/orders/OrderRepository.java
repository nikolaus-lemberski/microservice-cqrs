package com.lemberski.microservice.cqrs.myorders;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Iterable<Order> findByUserId(String userId);
    
}
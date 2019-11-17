package com.lemberski.microservice.cqrs.orders;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("select * from Order o where o.userId = :userId order by orderDate DESC")
    Iterable<Order> findByUserId(String userId);
    
}
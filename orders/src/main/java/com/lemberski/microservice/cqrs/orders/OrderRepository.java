package com.lemberski.microservice.cqrs.orders;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("select * from order_item o where o.user_id = :userId order by o.order_date DESC")
    Iterable<Order> findByUserId(@Param("userId") String userId);

    @Query("select * from order_item o where o.order_id = :orderId")
    Iterable<Order> findByOrderId(@Param("orderId") Long orderId);
    
}
package com.lemberski.microservice.cqrs.orders;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("order_item")
public class Order {

    private Long id;
    private String userId;
    private Date orderDate;
    private Double totalPrice;
    private String status;
    
}
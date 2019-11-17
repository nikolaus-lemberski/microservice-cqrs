package com.lemberski.microservice.cqrs.myorders;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = "products")
@NoArgsConstructor
@AllArgsConstructor
@Table("order_item")
public class Order {

    @Id
    private Long id;
    private String userId;
    private Date orderDate;
    private Date totalPrice;
    private String status;
    
}
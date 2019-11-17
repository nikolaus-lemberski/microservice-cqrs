package com.lemberski.microservice.cqrs.ordersystem;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Table("product_item")
public class Product {

    @Id
    private Long id;
    private String sku;
    private String title;
    private String description;
    private Double price;
    @JsonIgnore
    private Long orderItem;
    
}
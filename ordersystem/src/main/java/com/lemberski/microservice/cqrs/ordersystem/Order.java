package com.lemberski.microservice.cqrs.ordersystem;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(exclude = "products")
@NoArgsConstructor
@AllArgsConstructor
@Table("order_item")
public class Order {

    @Id
    private Long id;

    private String userId;

    @Embedded.Nullable
    private Address address;

    @CreatedDate
    private Date createdDate;

    @MappedCollection(idColumn = "order_item")
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

}
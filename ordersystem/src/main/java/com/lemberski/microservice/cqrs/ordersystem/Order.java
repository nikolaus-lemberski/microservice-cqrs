package com.lemberski.microservice.cqrs.ordersystem;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(exclude = "products")
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    @Embedded
    private Address address;

    @OneToMany(
        mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        product.setOrder(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setOrder(null);
    }

}
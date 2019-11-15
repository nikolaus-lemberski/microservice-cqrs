package com.lemberski.microservice.cqrs.ordersystem;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Address {

    private String firstName;
    private String lastName;
    private String street;
    private String zip;
    private String city;
    private String country;

}
package com.lemberski.microservice.cqrs.ordersystem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {

    private String firstName;
    private String lastName;
    private String street;
    private String zip;
    private String city;
    private String country;

}
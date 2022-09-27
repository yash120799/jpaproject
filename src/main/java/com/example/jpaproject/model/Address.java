package com.example.jpaproject.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Address {
    private String address1;
    private String address2;
    private String city;
    private  String state;
    private Long zipcode;

}

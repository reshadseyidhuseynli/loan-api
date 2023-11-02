package com.company.loanapijdbc.domain;

import lombok.Data;

@Data
public class Address {

    private Integer id;
    private String country;
    private String city;
    private String street;
    private String postalCode;

}

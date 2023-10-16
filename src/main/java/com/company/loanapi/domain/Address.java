package com.company.loanapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private Integer id;
    private String country;
    private String city;
    private String street;
    private String postalCode;

}

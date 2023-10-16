package com.company.loanapi.dto.response;

import lombok.Data;

@Data
public class AddressResponse {

    private Integer id;
    private String country;
    private String city;
    private String street;
    private String postalCode;

}

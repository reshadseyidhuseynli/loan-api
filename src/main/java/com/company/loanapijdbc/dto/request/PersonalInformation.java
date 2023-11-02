package com.company.loanapijdbc.dto.request;

import lombok.Data;

@Data
public class PersonalInformation {

    private ContactRequest contactRequest;
    private AddressRequest addressRequest;

}

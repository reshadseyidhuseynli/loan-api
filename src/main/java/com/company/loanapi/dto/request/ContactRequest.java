package com.company.loanapi.dto.request;

import lombok.Data;

@Data
public class ContactRequest {

    private String homeNumber;
    private String workNumber;
    private String mobileNumber;
    private String email;
}

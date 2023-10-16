package com.company.loanapi.dto.response;

import lombok.Data;

@Data
public class ContactResponse {

    private Integer id;
    private String homeNumber;
    private String workNumber;
    private String mobileNumber;
    private String email;

}

package com.company.loanapijdbc.domain;

import lombok.Data;

@Data
public class Contact {

    private Integer id;
    private String homeNumber;
    private String workNumber;
    private String mobileNumber;
    private String email;

}

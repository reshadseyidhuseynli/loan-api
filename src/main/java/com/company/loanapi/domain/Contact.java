package com.company.loanapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private Integer id;
    private String homeNumber;
    private String workNumber;
    private String mobileNumber;
    private String email;
    private Integer customerId;
}

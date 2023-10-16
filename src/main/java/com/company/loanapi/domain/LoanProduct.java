package com.company.loanapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanProduct {

    private Integer id;
    private Integer loanId;
    private Integer productId;
}

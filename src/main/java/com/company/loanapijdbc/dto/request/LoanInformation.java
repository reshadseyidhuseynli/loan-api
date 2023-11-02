package com.company.loanapijdbc.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class LoanInformation {

    private BigDecimal interestRate;
    private List<ProductRequest> products;

}

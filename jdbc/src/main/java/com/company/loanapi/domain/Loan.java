package com.company.loanapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    private Integer id;
    private BigDecimal totalAmount;
    private BigDecimal preAmount;
    private BigDecimal interestRate;
    private Integer customerId;

}

package com.company.loanapi.dto;

import com.company.loanapi.dto.response.LoanProductResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class LoanDto {

    private Integer id;
    private BigDecimal totalAmount;
    private BigDecimal preAmount;
    private BigDecimal interestRate;
    private List<LoanProductResponse> products;

}

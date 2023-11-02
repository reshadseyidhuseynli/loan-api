package com.company.loanapijdbc.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer loanId;

}

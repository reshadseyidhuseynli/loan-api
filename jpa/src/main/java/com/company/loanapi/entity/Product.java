package com.company.loanapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "loan_id", referencedColumnName = "id")
    private Loan loan;

}

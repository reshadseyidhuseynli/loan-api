package com.company.loanapi.repository;

import com.company.loanapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Modifying
    @Query(value = "INSERT INTO product (name, price, loan_id) " +
            "VALUES(?1, ?2, ?3)", nativeQuery = true)
    void createProductForLoan(String name, BigDecimal price, Integer loanId);

}

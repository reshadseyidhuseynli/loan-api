package com.company.loanapi.repository;

import com.company.loanapi.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

    @Modifying
    @Query(value = "INSERT INTO loan (customer_id, interest_rate) " +
            "VALUES(?1, ?2)", nativeQuery = true)
    Integer createLoanForCustomer(Integer customerId, BigDecimal interestRate);

}

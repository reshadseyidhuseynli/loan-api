package com.company.loanapi.service;

import com.company.loanapi.domain.Loan;
import com.company.loanapi.dto.request.ProductRequest;
import com.company.loanapi.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private static final Double PRE_AMOUNT_PERCENT = 30.0;

    private final LoanRepository loanRepository;
    private final ProductService productService;

    public int create(Integer customerId, BigDecimal interestRate) {
        Loan loan = new Loan();
        loan.setCustomerId(customerId);
        loan.setInterestRate(interestRate);

        return loanRepository.create(loan);
    }

    public void addProductsToLoan(Integer loanId, List<ProductRequest> productRequests) {
        BigDecimal totalAmount = productService
                .createProducts(loanId, productRequests);
        BigDecimal preAmount = totalAmount
                .multiply(BigDecimal.valueOf(PRE_AMOUNT_PERCENT / 100));

        Loan loan = loanRepository.getById(loanId);
        loan.setTotalAmount(totalAmount);
        loan.setPreAmount(preAmount);

        loanRepository.update(loan);
    }

}

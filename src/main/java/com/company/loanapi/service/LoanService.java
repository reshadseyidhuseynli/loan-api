package com.company.loanapi.service;

import com.company.loanapi.domain.Loan;
import com.company.loanapi.dto.LoanDto;
import com.company.loanapi.dto.response.LoanProductResponse;
import com.company.loanapi.mapper.LoanMapper;
import com.company.loanapi.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;
    private final ProductService productService;
    private final LoanProductService loanProductService;

    private static final Double PRE_AMOUNT_PERCENT = 30.0;

    public int create(Integer customerId, BigDecimal interestRate) {

        Loan loan = new Loan();
        loan.setCustomerId(customerId);
        loan.setInterestRate(interestRate);
        return loanRepository.create(loan);

    }

    public LoanDto getById(Integer id) {
        Loan loan = loanRepository.getById(id);
        return loanMapper.toLoanDto(loan);
    }

    public void addCalculatedTotalAmountAndPreAmount(Integer loanId, List<LoanProductResponse> loanProductResponseList) {

        BigDecimal totalAmount = loanProductResponseList.stream()
                .map(LoanProductResponse::getProductId)
                .map(productId -> productService.getById(productId).getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        LoanDto loanDto = getById(loanId);
        loanDto.setTotalAmount(totalAmount);
        loanDto.setPreAmount(totalAmount.multiply(BigDecimal.valueOf(PRE_AMOUNT_PERCENT / 100)));

        updateLoanDto(loanDto);

    }

    public void addProductsToLoan(Integer loanId, List<LoanProductResponse> loanProductResponseList) {

        LoanDto loanDto = getById(loanId);
        loanDto.setProducts(loanProductResponseList);

        updateLoanDto(loanDto);

    }

    private void updateLoanDto(LoanDto loanDto) {

        Loan loan = loanMapper.toLoan(loanDto);
        loanRepository.update(loan);

    }

}

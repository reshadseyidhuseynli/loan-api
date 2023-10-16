package com.company.loanapi.service;

import com.company.loanapi.domain.enamuration.ActionStatus;
import com.company.loanapi.dto.response.LoanProductResponse;
import com.company.loanapi.dto.response.TransactionResponse;
import com.company.loanapi.dto.request.LoanInformation;
import com.company.loanapi.dto.request.PassportRequest;
import com.company.loanapi.dto.request.PersonalInformation;
import com.company.loanapi.error.model.IdentityCheckException;
import com.company.loanapi.error.model.InitialCheckException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditorService {

    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final LoanService loanService;
    private final LoanProductService loanProductService;

    public void checkIdentity(PassportRequest passportRequest) {

        Integer customerId = customerService.create(passportRequest);
        customerService.addTransactionToCustomer(customerId);

    }

    public void initialApprove(Integer id, PersonalInformation personalInformation) {

        TransactionResponse transaction = transactionService.getById(id);

        if (transaction.getActionStatus() != ActionStatus.IDENTITY_CHECK_APPROVED)
            throw new IdentityCheckException("Identity check failed: " + transaction.getRejectReason());

        customerService.addPersonalInformationToCustomer(id, personalInformation);

        transaction.setActionStatus(ActionStatus.WAITING_FOR_INITIAL_APPROVE);
        transactionService.update(transaction);

    }

    public void finalApprove(Integer id, LoanInformation loanInformation) {

        TransactionResponse transaction = transactionService.getById(id);

        if (transaction.getActionStatus() != ActionStatus.INITIAL_CHECK_APPROVED)
            throw new InitialCheckException("Initial check failed: " + transaction.getRejectReason());

        int loanId = loanService.create(id, loanInformation.getInterestRate());
        List<LoanProductResponse> loanProductResponseList =
                loanProductService.createLoanProducts(loanId, loanInformation.getProducts());
        loanService.addProductsToLoan(loanId, loanProductResponseList);
        loanService.addCalculatedTotalAmountAndPreAmount(loanId, loanProductResponseList);

        transaction.setActionStatus(ActionStatus.WAITING_FOR_FINAL_APPROVE);
        transactionService.update(transaction);

    }
}

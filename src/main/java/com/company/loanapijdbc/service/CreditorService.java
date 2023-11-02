package com.company.loanapijdbc.service;

import com.company.loanapijdbc.domain.enamuration.ActionStatus;
import com.company.loanapijdbc.dto.TransactionDto;
import com.company.loanapijdbc.dto.request.LoanInformation;
import com.company.loanapijdbc.dto.request.PassportRequest;
import com.company.loanapijdbc.dto.request.PersonalInformation;
import com.company.loanapijdbc.exception.IdentityCheckException;
import com.company.loanapijdbc.exception.InitialCheckException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditorService {

    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final LoanService loanService;

    public void checkIdentity(PassportRequest passportRequest) {
        Integer customerId = customerService.create(passportRequest);
        transactionService.create(customerId);
    }

    public void initialApprove(Integer transactionId, PersonalInformation personalInformation) {
        TransactionDto transaction = transactionService.getById(transactionId);
        Integer customerId = transaction.getCustomerId();


        if (transaction.getActionStatus() != ActionStatus.IDENTITY_CHECK_APPROVED) {
            throw new IdentityCheckException("Identity check failed: " + transaction.getRejectReason());
        }

        customerService.addPersonalInformationToCustomer(customerId, personalInformation);

        transaction.setActionStatus(ActionStatus.WAITING_FOR_INITIAL_APPROVE);
        transactionService.update(transaction);
    }

    public void finalApprove(Integer transactionId, LoanInformation loanInformation) {
        TransactionDto transaction = transactionService.getById(transactionId);
        Integer customerId = transaction.getCustomerId();

        if (transaction.getActionStatus() != ActionStatus.INITIAL_CHECK_APPROVED) {
            throw new InitialCheckException("Initial check failed: " + transaction.getRejectReason());
        }

        int loanId = loanService.create(customerId, loanInformation.getInterestRate());
        loanService.addProductsToLoan(loanId, loanInformation.getProducts());

        transaction.setActionStatus(ActionStatus.WAITING_FOR_FINAL_APPROVE);
        transactionService.update(transaction);
    }

}

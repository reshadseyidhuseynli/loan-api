package com.company.loanapi.service;

import com.company.loanapi.domain.enamuration.ActionStatus;
import com.company.loanapi.domain.enamuration.FinalStatus;
import com.company.loanapi.domain.enamuration.LeadReply;
import com.company.loanapi.dto.response.TransactionResponse;
import com.company.loanapi.error.model.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LeadService {

    private final TransactionService transactionService;

    public void identifyStatus(Integer transactionId, LeadReply reply, String rejectReason) {

        checkRequest(reply, rejectReason);
        updateTransaction(
                transactionId,
                reply,
                rejectReason,
                ActionStatus.IDENTITY_CHECK_APPROVED,
                false);

    }

    public void initialStatus(Integer transactionId, LeadReply reply, String rejectReason) {

        checkRequest(reply, rejectReason);
        updateTransaction(
                transactionId,
                reply,
                rejectReason,
                ActionStatus.INITIAL_CHECK_APPROVED,
                false);

    }

    public void finalStatus(Integer transactionId, LeadReply reply, String rejectReason) {

        checkRequest(reply, rejectReason);
        updateTransaction(
                transactionId,
                reply,
                rejectReason,
                ActionStatus.FINAL_CHECK_APPROVED,
                true);

    }

    private void checkRequest(LeadReply reply, String rejectReason) {

        if (reply != LeadReply.APPROVE && Objects.isNull(rejectReason)) {
            throw new BadRequestException("Reject reason can not be empty");
        }

    }

    private void updateTransaction(Integer transactionId,
                                   LeadReply reply,
                                   String rejectReason,
                                   ActionStatus nextStatus,
                                   boolean isFinal) {

        TransactionResponse transaction = transactionService.getById(transactionId);
        if (reply == LeadReply.APPROVE) {
            transaction.setActionStatus(nextStatus);
            if (isFinal) {
                transaction.setFinalStatus(FinalStatus.COMPLETED);
            }
        } else {
            transaction.setRejectReason(rejectReason);
        }
        transactionService.update(transaction);
    }

}

package com.company.loanapi.service;

import com.company.loanapi.domain.Transaction;
import com.company.loanapi.domain.enamuration.ActionStatus;
import com.company.loanapi.domain.enamuration.FinalStatus;
import com.company.loanapi.dto.response.TransactionResponse;
import com.company.loanapi.mapper.TransactionMapper;
import com.company.loanapi.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionResponse create() {

        Transaction transaction = new Transaction();
        transaction.setActionStatus(ActionStatus.WAITING_FOR_IDENTITY_APPROVE);
        transaction.setFinalStatus(FinalStatus.IN_PROGRESS);

        int transactionId = transactionRepository.create(transaction);
        transaction.setId(transactionId);

        return transactionMapper.toTransactionDto(transaction);

    }

    public TransactionResponse getById(Integer id) {

        Transaction transaction = transactionRepository.getById(id);
        return transactionMapper.toTransactionDto(transaction);

    }

    public void update(TransactionResponse transactionResponse) {

        Transaction transaction = transactionMapper.toTransaction(transactionResponse);
        transactionRepository.update(transaction);

    }

}

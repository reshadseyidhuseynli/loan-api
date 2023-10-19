package com.company.loanapi.service;

import com.company.loanapi.domain.Transaction;
import com.company.loanapi.domain.enamuration.ActionStatus;
import com.company.loanapi.domain.enamuration.FinalStatus;
import com.company.loanapi.dto.TransactionDto;
import com.company.loanapi.mapper.TransactionMapper;
import com.company.loanapi.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public void create(Integer customerId) {
        Transaction transaction = new Transaction();
        transaction.setActionStatus(ActionStatus.WAITING_FOR_IDENTITY_APPROVE);
        transaction.setFinalStatus(FinalStatus.IN_PROGRESS);
        transaction.setCustomerId(customerId);

        transactionRepository.create(transaction);
    }

    public TransactionDto getById(Integer id) {
        Transaction transaction = transactionRepository.getById(id);
        return transactionMapper.toTransactionDto(transaction);
    }

    public void update(TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.toTransaction(transactionDto);
        transactionRepository.update(transaction);
    }

}

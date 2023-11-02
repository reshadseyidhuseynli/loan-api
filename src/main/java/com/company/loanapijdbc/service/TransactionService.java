package com.company.loanapijdbc.service;

import com.company.loanapijdbc.domain.Transaction;
import com.company.loanapijdbc.domain.enamuration.ActionStatus;
import com.company.loanapijdbc.domain.enamuration.FinalStatus;
import com.company.loanapijdbc.dto.TransactionDto;
import com.company.loanapijdbc.mapper.TransactionMapper;
import com.company.loanapijdbc.repository.TransactionRepository;
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

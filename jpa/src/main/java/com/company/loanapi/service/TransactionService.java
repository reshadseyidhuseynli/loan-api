package com.company.loanapi.service;

import com.company.loanapi.dto.TransactionDto;
import com.company.loanapi.enamuration.ActionStatus;
import com.company.loanapi.enamuration.FinalStatus;
import com.company.loanapi.entity.Transaction;
import com.company.loanapi.error.exception.NotFoundException;
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
        transactionRepository.createTransactionForCustomer(
                ActionStatus.WAITING_FOR_IDENTITY_APPROVE,
                FinalStatus.IN_PROGRESS,
                customerId
        );
    }

    public TransactionDto getById(Integer id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Transaction not found with given id: " + id));
        return transactionMapper.toTransactionDto(transaction);
    }

    public void update(TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.toTransaction(transactionDto);
        transactionRepository.save(transaction);
    }

}

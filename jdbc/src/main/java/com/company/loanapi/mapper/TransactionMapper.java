package com.company.loanapi.mapper;

import com.company.loanapi.domain.Transaction;
import com.company.loanapi.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toTransaction(TransactionDto transactionDto);

    TransactionDto toTransactionDto(Transaction transaction);
}

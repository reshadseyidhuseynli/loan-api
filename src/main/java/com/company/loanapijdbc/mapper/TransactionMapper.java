package com.company.loanapijdbc.mapper;

import com.company.loanapijdbc.domain.Transaction;
import com.company.loanapijdbc.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toTransaction(TransactionDto transactionDto);

    TransactionDto toTransactionDto(Transaction transaction);
}

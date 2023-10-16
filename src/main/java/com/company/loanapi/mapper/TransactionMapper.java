package com.company.loanapi.mapper;

import com.company.loanapi.domain.Transaction;
import com.company.loanapi.dto.response.TransactionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toTransaction(TransactionResponse transactionResponse);

    TransactionResponse toTransactionDto(Transaction transaction);
}

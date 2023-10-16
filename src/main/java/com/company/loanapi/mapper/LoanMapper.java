package com.company.loanapi.mapper;

import com.company.loanapi.domain.Loan;
import com.company.loanapi.dto.LoanDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    Loan toLoan(LoanDto loanDto);

    LoanDto toLoanDto(Loan loan);

}

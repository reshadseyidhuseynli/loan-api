package com.company.loanapijdbc.mapper;

import com.company.loanapijdbc.domain.Customer;
import com.company.loanapijdbc.dto.request.PassportRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(PassportRequest passportRequest);

}

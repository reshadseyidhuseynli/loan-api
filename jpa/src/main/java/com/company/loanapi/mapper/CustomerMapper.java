package com.company.loanapi.mapper;

import com.company.loanapi.entity.Customer;
import com.company.loanapi.dto.request.PassportRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(PassportRequest passportRequest);

}

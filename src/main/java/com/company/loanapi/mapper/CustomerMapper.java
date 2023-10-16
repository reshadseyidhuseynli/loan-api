package com.company.loanapi.mapper;

import com.company.loanapi.domain.Customer;
import com.company.loanapi.dto.request.PassportRequest;
import com.company.loanapi.dto.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(PassportRequest passportRequest);

    CustomerResponse toCustomerDto(Customer customer);

    Customer toCustomerFromCustomerDto(CustomerResponse customerResponse);

}

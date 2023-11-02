package com.company.loanapijdbc.mapper;

import com.company.loanapijdbc.domain.Address;
import com.company.loanapijdbc.dto.request.AddressRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressRequest addressRequest);

}

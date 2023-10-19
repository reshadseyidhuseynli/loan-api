package com.company.loanapi.mapper;

import com.company.loanapi.entity.Address;
import com.company.loanapi.dto.request.AddressRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressRequest addressRequest);

}

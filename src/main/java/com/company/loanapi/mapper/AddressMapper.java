package com.company.loanapi.mapper;

import com.company.loanapi.domain.Address;
import com.company.loanapi.dto.request.AddressRequest;
import com.company.loanapi.dto.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressRequest addressRequest);

    AddressResponse toAddressResponse(Address address);

}

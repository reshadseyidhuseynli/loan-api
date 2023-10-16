package com.company.loanapi.service;

import com.company.loanapi.domain.Address;
import com.company.loanapi.dto.request.AddressRequest;
import com.company.loanapi.dto.response.AddressResponse;
import com.company.loanapi.mapper.AddressMapper;
import com.company.loanapi.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressResponse create(AddressRequest addressRequest) {

        Address address = addressMapper.toAddress(addressRequest);
        int addressId = addressRepository.create(address);
        address.setId(addressId);
        return addressMapper.toAddressResponse(address);

    }
}

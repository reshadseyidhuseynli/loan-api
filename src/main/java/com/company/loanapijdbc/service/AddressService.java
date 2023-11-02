package com.company.loanapijdbc.service;

import com.company.loanapijdbc.domain.Address;
import com.company.loanapijdbc.dto.request.AddressRequest;
import com.company.loanapijdbc.mapper.AddressMapper;
import com.company.loanapijdbc.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public int create(AddressRequest addressRequest) {
        Address address = addressMapper.toAddress(addressRequest);
        return addressRepository.create(address);
    }

}

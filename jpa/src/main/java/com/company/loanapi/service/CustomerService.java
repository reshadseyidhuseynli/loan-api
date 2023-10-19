package com.company.loanapi.service;

import com.company.loanapi.entity.Customer;
import com.company.loanapi.dto.request.PassportRequest;
import com.company.loanapi.dto.request.PersonalInformation;
import com.company.loanapi.error.exception.NotFoundException;
import com.company.loanapi.mapper.CustomerMapper;
import com.company.loanapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final ContactService contactService;
    private final AddressService addressService;

    public Integer create(PassportRequest passportRequest) {
        Customer customer = customerMapper.toCustomer(passportRequest);
        return customerRepository.save(customer).getId();
    }

    public void addPersonalInformationToCustomer(Integer customerId,
                                                 PersonalInformation personalInformation) {
        int contactId = contactService.create(personalInformation.getContactRequest());
        int addressId = addressService.create(personalInformation.getAddressRequest());

        customerRepository.addContactAndAddressToCustomer(contactId, addressId, customerId);
    }

}

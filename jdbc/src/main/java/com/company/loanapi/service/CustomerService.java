package com.company.loanapi.service;

import com.company.loanapi.domain.Customer;
import com.company.loanapi.dto.request.PassportRequest;
import com.company.loanapi.dto.request.PersonalInformation;
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
        return customerRepository.create(customer);
    }

    public void addPersonalInformationToCustomer(Integer customerId,
                                                 PersonalInformation personalInformation) {
        int contactId = contactService.create(personalInformation.getContactRequest());
        int addressId = addressService.create(personalInformation.getAddressRequest());

        Customer customer = customerRepository.getById(customerId);
        customer.setContactId(contactId);
        customer.setAddressId(addressId);

        customerRepository.update(customer);
    }

}

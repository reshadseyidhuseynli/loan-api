package com.company.loanapi.service;

import com.company.loanapi.domain.Customer;
import com.company.loanapi.dto.response.CustomerResponse;
import com.company.loanapi.dto.response.TransactionResponse;
import com.company.loanapi.dto.request.PassportRequest;
import com.company.loanapi.dto.request.PersonalInformation;
import com.company.loanapi.dto.response.AddressResponse;
import com.company.loanapi.dto.response.ContactResponse;
import com.company.loanapi.mapper.CustomerMapper;
import com.company.loanapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final TransactionService transactionService;
    private final ContactService contactService;
    private final AddressService addressService;

    public Integer create(PassportRequest passportRequest) {

        Customer customer = customerMapper.toCustomer(passportRequest);
        return customerRepository.create(customer);

    }

    public CustomerResponse getById(Integer id) {

        Customer customer = customerRepository.getById(id);
        return customerMapper.toCustomerDto(customer);

    }

    public void addTransactionToCustomer(Integer customerId) {

        TransactionResponse transactionResponse = transactionService.create();

        CustomerResponse customerResponse = getById(customerId);
        customerResponse.setTransaction(transactionResponse);

        updateCustomerResponse(customerResponse);
    }

    public void addPersonalInformationToCustomer(Integer customerId, PersonalInformation personalInformation) {

        ContactResponse contactResponse = contactService.create(personalInformation.getContactRequest());
        AddressResponse addressResponse = addressService.create(personalInformation.getAddressRequest());

        CustomerResponse customerResponse = getById(customerId);
        customerResponse.setContact(contactResponse);
        customerResponse.setAddress(addressResponse);

        updateCustomerResponse(customerResponse);

    }

    private void updateCustomerResponse(CustomerResponse customerResponse) {

        Customer customer = customerMapper.toCustomerFromCustomerDto(customerResponse);
        customerRepository.update(customer);

    }

}

package com.company.loanapijdbc.service;

import com.company.loanapijdbc.domain.Contact;
import com.company.loanapijdbc.dto.request.ContactRequest;
import com.company.loanapijdbc.mapper.ContactMapper;
import com.company.loanapijdbc.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public int create(ContactRequest contactRequest) {
        Contact contact = contactMapper.toContact(contactRequest);
        return contactRepository.create(contact);
    }

}

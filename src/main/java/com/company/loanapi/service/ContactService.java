package com.company.loanapi.service;

import com.company.loanapi.domain.Contact;
import com.company.loanapi.dto.request.ContactRequest;
import com.company.loanapi.dto.response.ContactResponse;
import com.company.loanapi.mapper.ContactMapper;
import com.company.loanapi.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactResponse create(ContactRequest contactRequest) {
        Contact contact = contactMapper.toContact(contactRequest);
        int contactId = contactRepository.create(contact);
        contact.setId(contactId);
        return contactMapper.toContactResponse(contact);
    }
}

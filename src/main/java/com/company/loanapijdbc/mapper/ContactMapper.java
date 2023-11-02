package com.company.loanapijdbc.mapper;

import com.company.loanapijdbc.domain.Contact;
import com.company.loanapijdbc.dto.request.ContactRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toContact(ContactRequest contactRequest);

}

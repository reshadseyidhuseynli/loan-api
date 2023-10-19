package com.company.loanapi.mapper;

import com.company.loanapi.domain.Contact;
import com.company.loanapi.dto.request.ContactRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toContact(ContactRequest contactRequest);

}

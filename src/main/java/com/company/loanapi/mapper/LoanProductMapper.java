package com.company.loanapi.mapper;

import com.company.loanapi.domain.LoanProduct;
import com.company.loanapi.dto.response.LoanProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanProductMapper {

    LoanProduct toLoanProduct(LoanProductResponse loanProductResponse);

    List<LoanProductResponse> toLoanProductDtoList(List<LoanProduct> loanProducts);

}

package com.company.loanapijdbc.mapper;

import com.company.loanapijdbc.domain.Product;
import com.company.loanapijdbc.dto.request.ProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductRequest productRequest);

}

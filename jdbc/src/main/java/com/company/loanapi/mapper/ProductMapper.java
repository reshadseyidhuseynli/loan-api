package com.company.loanapi.mapper;

import com.company.loanapi.domain.Product;
import com.company.loanapi.dto.request.ProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductRequest productRequest);

}

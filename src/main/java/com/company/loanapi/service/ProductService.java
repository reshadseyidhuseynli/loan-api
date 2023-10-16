package com.company.loanapi.service;

import com.company.loanapi.domain.Product;
import com.company.loanapi.dto.request.ProductRequest;
import com.company.loanapi.mapper.ProductMapper;
import com.company.loanapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public int create(ProductRequest productRequest) {

        Product product = productMapper.toProduct(productRequest);
        return productRepository.create(product);

    }

    public ProductRequest getById(Integer id) {
        Product product = productRepository.getById(id);
        return productMapper.toProductDto(product);
    }

}

package com.company.loanapi.service;

import com.company.loanapi.domain.Product;
import com.company.loanapi.dto.request.ProductRequest;
import com.company.loanapi.mapper.ProductMapper;
import com.company.loanapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public BigDecimal createProducts(Integer loanId, List<ProductRequest> productRequests) {
        return productRequests
                .stream()
                .map(productRequest -> {
                            Product product = productMapper.toProduct(productRequest);
                            product.setLoanId(loanId);
                            productRepository.create(product);

                            return product.getPrice();
                        }
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}

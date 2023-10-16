package com.company.loanapi.service;

import com.company.loanapi.domain.LoanProduct;
import com.company.loanapi.dto.response.LoanProductResponse;
import com.company.loanapi.dto.request.ProductRequest;
import com.company.loanapi.mapper.LoanProductMapper;
import com.company.loanapi.repository.LoanProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanProductService {

    private final LoanProductRepository loanProductRepository;
    private final LoanProductMapper loanProductMapper;
    private final ProductService productService;

    public void create(LoanProductResponse loanProductResponse) {

        LoanProduct loanProduct = loanProductMapper.toLoanProduct(loanProductResponse);
        loanProductRepository.create(loanProduct);

    }

    public List<LoanProductResponse> createLoanProducts(Integer loanId, List<ProductRequest> productRequestList) {

        List<LoanProductResponse> loanProductResponseList = productRequestList.stream()
                .map(productRequest -> {
                    LoanProductResponse loanProductResponse = new LoanProductResponse();

                    int productId = productService.create(productRequest);
                    loanProductResponse.setProductId(productId);
                    loanProductResponse.setLoanId(loanId);

                    return loanProductResponse;
                })
                .collect(Collectors.toList());

        loanProductResponseList.forEach(this::create);

        return loanProductResponseList;
    }

    public List<LoanProductResponse> getByLoanId(Integer loanId) {
        List<LoanProduct> loanProducts = loanProductRepository.getByLoanId(loanId);
        return loanProductMapper.toLoanProductDtoList(loanProducts);
    }

}

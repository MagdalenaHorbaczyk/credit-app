package com.creditapp.productservice.services;

import com.creditapp.productservice.dtos.requests.CreateProductRequest;
import com.creditapp.productservice.dtos.responses.CreateProductResponse;
import com.creditapp.productservice.dtos.responses.ProductForGetProductsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    public CreateProductResponse createProduct(CreateProductRequest request) {
        return response;
    }

    public List<ProductForGetProductsResponse> getAllProducts() {
        return response;
    }
}


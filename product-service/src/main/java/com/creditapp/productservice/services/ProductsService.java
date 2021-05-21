package com.creditapp.productservice.services;

import com.creditapp.productservice.dtos.requests.CreateProductRequest;
import com.creditapp.productservice.dtos.responses.CreateProductResponse;
import com.creditapp.productservice.dtos.responses.ProductForGetProductsResponse;
import com.creditapp.productservice.entities.Product;
import com.creditapp.productservice.exceptions.HttpException;
import com.creditapp.productservice.repositories.ProductsRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final ModelMapper modelMapper;

    public ProductsService(ProductsRepository productsRepository, ModelMapper modelMapper) {
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
    }

    public CreateProductResponse createProduct(CreateProductRequest request) {
        Product product = modelMapper.map(request, Product.class);
        if (productsRepository.existsByCreditId(product.getCreditId())) {
            throw new HttpException(("Credit number is already in use"), HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            Product response = productsRepository.save(product);
            return modelMapper.map(response, CreateProductResponse.class);
        }
    }
    public List<ProductForGetProductsResponse> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        productsRepository.findAll().iterator().forEachRemaining(allProducts::add);
        return modelMapper.map(allProducts, new TypeToken<List<ProductForGetProductsResponse>>() {
        }.getType());
    }
}


package com.creditapp.productservice.controllers;

import com.creditapp.productservice.dtos.requests.CreateProductRequest;
import com.creditapp.productservice.dtos.responses.CreateProductResponse;
import com.creditapp.productservice.dtos.responses.ProductForGetProductsResponse;
import com.creditapp.productservice.services.ProductsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@Validated
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<ProductForGetProductsResponse> getProducts() {
        return productsService.getAllProducts();
    }

    @PostMapping
    public CreateProductResponse createProduct(@Valid @RequestBody CreateProductRequest request) {
        return productsService.createProduct(request);
    }
}

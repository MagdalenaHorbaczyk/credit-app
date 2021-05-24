package com.creditapp.creditservice.services;

import com.creditapp.creditservice.beans.product.CreateProductRequest;
import com.creditapp.creditservice.beans.product.CreateProductResponse;
import com.creditapp.creditservice.beans.product.ProductForGetProductsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Repository
@FeignClient(url = "localhost:8100", name = "product-service")
public interface ProductServiceProxy {

    @GetMapping("/products")
    List<ProductForGetProductsResponse> getAllProducts();

    @PostMapping("/products")
    CreateProductResponse createProduct(@RequestBody CreateProductRequest productRequest);
}

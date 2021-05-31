package com.creditapp.productservice.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductForGetProductsResponse {
    private long id;
    private long creditId;
    private String productName;
    private int value;
}

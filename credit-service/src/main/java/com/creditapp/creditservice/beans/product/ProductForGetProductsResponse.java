package com.creditapp.creditservice.beans.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductForGetProductsResponse {
    private Long creditId;
    private String productName;
    private int value;
}

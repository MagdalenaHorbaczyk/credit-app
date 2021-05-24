package com.creditapp.creditservice.beans.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CreateProductRequest {
    private Long creditId;
    private String productName;
    private int value;
}

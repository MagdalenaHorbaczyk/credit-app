package com.creditapp.productservice.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

    @NotNull(message = "Please provide a credit number")
    @Digits(integer = 15, fraction = 0, message = "Please provide value in format: 0")
    @Column(unique = true, nullable = false)
    private Long creditId;

    @NotBlank(message = "Please provide a product name")
    @Size(min = 2, max = 255, message = "Minimum product name length: 2 characters, maximum: 255")
    private String productName;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 12, fraction = 2, message = "Please provide value in format: 0.0")
    private BigDecimal value;
}


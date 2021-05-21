package com.creditapp.creditservice.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditRequest {
    @NotBlank(message = "Please provide a firstname")
    @Size(min = 2, max = 255, message = "Minimum firstname length: 2 characters, maximum: 255")
    private String firstName;

    @NotBlank(message = "Please provide an surname")
    @Size(min = 2, max = 255, message = "Minimum surname length: 2 characters, maximum: 255")
    private String surName;

    private Long pesel;

    @NotBlank(message = "Please provide a product name")
    @Size(min = 2, max = 255, message = "Minimum length: 2 characters, maximum: 255")
    private String productName;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=12, fraction=2)
    private int value;

    @NotBlank(message = "Please provide an credit name")
    @Size(min = 4, max = 255, message = "Minimum length: 4 characters, maximum: 255")
    private String creditName;
}

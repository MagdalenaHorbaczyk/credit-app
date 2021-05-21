package com.creditapp.creditservice.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditForGetCreditsResponse {
    private Long id;
    private String firstName;
    private String surName;
    private Long pesel;
    private String productName;
    private int value;
    private String creditName;
}

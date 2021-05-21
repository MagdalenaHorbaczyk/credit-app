package com.creditapp.customerservice.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerForGetCustomersResponse {
    private Long creditId;
    private String firstName;
    private String surName;
    private Long pesel;
}

package com.creditapp.creditservice.beans.customer;

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
public class CreateCustomerResponse {
    private String firstName;
    private String surName;
    private Long pesel;
}

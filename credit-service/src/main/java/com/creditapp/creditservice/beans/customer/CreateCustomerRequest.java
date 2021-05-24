package com.creditapp.creditservice.beans.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CreateCustomerRequest {
    private Long creditId;

    @NotBlank(message = "Please provide a firstname")
    @Size(min = 2, max = 255, message = "Minimum firstname length: 2 characters, maximum: 255")
    private String firstName;

    @NotBlank(message = "Please provide an surname")
    @Size(min = 2, max = 255, message = "Minimum surname length: 2 characters, maximum: 255")
    private String surName;

    @NotBlank(message = "Please provide a pesel")
    private Long pesel;
}

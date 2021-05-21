package com.creditapp.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMERS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotNull(message = "Please provide a credit number")
    @Digits(integer=15, fraction=0, message = "Please provide value in format: 0")
    @Column(unique = true, nullable = false)
    private Long creditId;

    @NotBlank(message = "Please provide a firstname")
    @Size(min = 2, max = 255, message = "Minimum firstname length: 2 characters, maximum: 255")
    private String firstName;

    @NotBlank(message = "Please provide an surname")
    @Size(min = 2, max = 255, message = "Minimum surname length: 2 characters, maximum: 255")
    private String surName;

    private Long pesel;
}

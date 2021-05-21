package com.creditapp.customerservice.controllers;

import com.creditapp.customerservice.dtos.requests.CreateCustomerRequest;
import com.creditapp.customerservice.dtos.responses.CreateCustomerResponse;
import com.creditapp.customerservice.dtos.responses.CustomerForGetCustomersResponse;
import com.creditapp.customerservice.services.CustomersService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@Validated
@RequestMapping("/customers")
public class CustomersController {
    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    public List<CustomerForGetCustomersResponse> getCustomers() {
        return customersService.getAllCustomers();
    }

    @PostMapping
    public CreateCustomerResponse createCustomer(@Valid @RequestBody CreateCustomerRequest request) {
        return customersService.createCustomer(request);
    }
}

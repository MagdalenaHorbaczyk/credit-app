package com.creditapp.customerservice.services;

import com.creditapp.customerservice.dtos.requests.CreateCustomerRequest;
import com.creditapp.customerservice.dtos.responses.CreateCustomerResponse;
import com.creditapp.customerservice.dtos.responses.CustomerForGetCustomersResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        return response;
    }

    public List<CustomerForGetCustomersResponse> getAllCustomers() {
        return response;
    }
}

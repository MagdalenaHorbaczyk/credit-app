package com.creditapp.customerservice.services;

import com.creditapp.customerservice.dtos.requests.CreateCustomerRequest;
import com.creditapp.customerservice.dtos.responses.CreateCustomerResponse;
import com.creditapp.customerservice.dtos.responses.CustomerForGetCustomersResponse;
import com.creditapp.customerservice.entities.Customer;
import com.creditapp.customerservice.exceptions.HttpException;
import com.creditapp.customerservice.repositories.CustomersRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;
    private final ModelMapper modelMapper;

    public CustomersService(CustomersRepository customersRepository, ModelMapper modelMapper) {
        this.customersRepository = customersRepository;
        this.modelMapper = modelMapper;
    }

    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer customer = modelMapper.map(request, Customer.class);
        if (customersRepository.existsByCreditId(customer.getCreditId())) {
            throw new HttpException(("Credit number is already in use"), HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            Customer response = customersRepository.save(customer);
            return modelMapper.map(response, CreateCustomerResponse.class);
        }
    }

    public List<CustomerForGetCustomersResponse> getAllCustomers() {
        List<Customer> allCustomers = new ArrayList<>();
        customersRepository.findAll().iterator().forEachRemaining(allCustomers::add);
        return modelMapper.map(allCustomers, new TypeToken<List<CustomerForGetCustomersResponse>>() {
        }.getType());
    }
}


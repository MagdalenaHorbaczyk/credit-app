package com.creditapp.creditservice.services;

import com.creditapp.creditservice.beans.customer.CreateCustomerRequest;
import com.creditapp.creditservice.beans.customer.CreateCustomerResponse;
import com.creditapp.creditservice.beans.customer.CustomerForGetCustomersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
@FeignClient(url = "localhost:8200", name = "customer-service")
public interface CustomerServiceProxy {

    @GetMapping("/customers")
    List<CustomerForGetCustomersResponse> getAllCustomers();

    @PostMapping("/customers")
    CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest);
}

package com.creditapp.creditservice.services;

import com.creditapp.creditservice.beans.customer.CreateCustomerRequest;
import com.creditapp.creditservice.beans.customer.CustomerForGetCustomersResponse;
import com.creditapp.creditservice.beans.product.CreateProductRequest;
import com.creditapp.creditservice.beans.product.ProductForGetProductsResponse;
import com.creditapp.creditservice.dtos.requests.CreateCreditRequest;
import com.creditapp.creditservice.dtos.responses.CreateCreditResponse;
import com.creditapp.creditservice.dtos.responses.CreditForGetCreditsResponse;
import com.creditapp.creditservice.entities.Credit;
import com.creditapp.creditservice.repositories.CreditsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RefreshScope
@Service
public class CreditsService {
    private final CreditsRepository creditsRepository;
    private final ProductServiceProxy productProxy;
    private final CustomerServiceProxy customerProxy;
    private final ModelMapper modelMapper;

    public CreditsService(CreditsRepository creditsRepository, ProductServiceProxy productProxy,
                          CustomerServiceProxy customerProxy, ModelMapper modelMapper) {
        this.creditsRepository = creditsRepository;
        this.productProxy = productProxy;
        this.customerProxy = customerProxy;
        this.modelMapper = modelMapper;
    }

    public List<CreditForGetCreditsResponse> getAllCredits() {
        List<CreditForGetCreditsResponse> allCreditsResponse = new ArrayList();
        List<Credit> allCredits = creditsRepository.findAll();
        List<CustomerForGetCustomersResponse> getCustomersResponse = customerProxy.getAllCustomers();
        List<ProductForGetProductsResponse> getProductsResponse = productProxy.getAllProducts();

        allCredits.forEach(credit -> getCustomersResponse.forEach(customerResponse -> getProductsResponse.forEach(productResponse -> {
            if (credit.getId().equals(customerResponse.getCreditId()) && credit.getId().equals(productResponse.getCreditId())) {
                CreditForGetCreditsResponse creditResponse = setCreditsResponse(credit, customerResponse, productResponse);
                allCreditsResponse.add(creditResponse);
            }
        })));
        return allCreditsResponse;
    }

    private CreditForGetCreditsResponse setCreditsResponse(Credit credit, CustomerForGetCustomersResponse
            customerResponse, ProductForGetProductsResponse productResponse) {
        CreditForGetCreditsResponse creditResponse = new CreditForGetCreditsResponse();
        creditResponse.setId(credit.getId());
        creditResponse.setCreditName(credit.getCreditName());
        creditResponse.setProductName(productResponse.getProductName());
        creditResponse.setValue(productResponse.getValue());
        creditResponse.setFirstName(customerResponse.getFirstName());
        creditResponse.setSurName(customerResponse.getSurName());
        creditResponse.setPesel(customerResponse.getPesel());
        return creditResponse;
    }

    public CreateCreditResponse createCredit(CreateCreditRequest request) {
        Credit savedCredit = getCredit(request);
        saveNewProduct(request, savedCredit);
        saveNewCustomer(request, savedCredit);
        Long creditNo = savedCredit.getId();
        return getCreateCreditResponse(creditNo);
    }

    private CreateCreditResponse getCreateCreditResponse(Long creditNo) {
        CreateCreditResponse response = new CreateCreditResponse();
        response.setCreditNo(creditNo);
        return response;
    }

    private Credit getCredit(CreateCreditRequest request) {
        CreateCreditRequest creditToSave = new CreateCreditRequest();
        creditToSave.setCreditName(request.getCreditName());
        return creditsRepository.save(modelMapper.map((creditToSave), Credit.class));
    }

    private void saveNewCustomer(CreateCreditRequest request, Credit savedCredit) {
        CreateCustomerRequest customerToSave = new CreateCustomerRequest();
        customerToSave.setCreditId(savedCredit.getId());
        customerToSave.setFirstName(request.getFirstName());
        customerToSave.setSurName(request.getSurName());
        customerToSave.setPesel(request.getPesel());
        customerProxy.createCustomer(customerToSave);
    }

    private void saveNewProduct(CreateCreditRequest request, Credit savedCredit) {
        CreateProductRequest productToSave = new CreateProductRequest();
        productToSave.setCreditId(savedCredit.getId());
        productToSave.setProductName(request.getProductName());
        productToSave.setValue((request.getValue()));
        productProxy.createProduct(productToSave);
    }
}

// createCredit method I presume should also need to be validated in case of duplicated creditId if data in credit bd would
// have been lost and data in product and customer database not. For further implementation in my spare time..

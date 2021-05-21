package com.creditapp.creditservice.services;

import com.creditapp.creditservice.dtos.requests.CreateCreditRequest;
import com.creditapp.creditservice.dtos.responses.CreateCreditResponse;
import com.creditapp.creditservice.dtos.responses.CreditForGetCreditsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditsService {

    public List<CreditForGetCreditsResponse> getAllCredits() {

        return response;
    }

    public CreateCreditResponse createCredit(CreateCreditRequest request) {
        return response;
    }
}

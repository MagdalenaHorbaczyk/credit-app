package com.creditapp.creditservice.controllers;

import com.creditapp.creditservice.dtos.requests.CreateCreditRequest;
import com.creditapp.creditservice.dtos.responses.CreateCreditResponse;
import com.creditapp.creditservice.dtos.responses.CreditForGetCreditsResponse;
import com.creditapp.creditservice.services.CreditsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@Validated
@RequestMapping("/credits")
public class CreditsController {
    private final CreditsService creditsService;

    public CreditsController(CreditsService creditsService) {
        this.creditsService = creditsService;
    }

    @GetMapping
    public List<CreditForGetCreditsResponse> getCredits() {
        return creditsService.getAllCredits();
    }

    @PostMapping
    public CreateCreditResponse createCredit(@Valid @RequestBody CreateCreditRequest request) {
        return creditsService.createCredit(request);
    }
}

package com.creditapp.creditservice.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditResponse {
    private Long creditNo;

    @Override
    public String toString() {
        return "CreateCreditResponse{" +
                "creditNo=" + creditNo +
                '}';
    }
}

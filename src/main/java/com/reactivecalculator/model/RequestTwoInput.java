package com.reactivecalculator.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestTwoInput extends RequestSingleInput {
    protected double num2;

    public RequestTwoInput(Object getNum1, int i) {
    }
}

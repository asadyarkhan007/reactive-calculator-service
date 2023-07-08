package com.reactivecalculator.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTwoInput extends RequestSingleInput {
    protected double num2;
    @Builder
    public RequestTwoInput(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}

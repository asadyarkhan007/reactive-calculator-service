package com.reactivecalculator.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class FactorialDto {
    private double factValue;
    private int counter;
}

package com.reactivecalculator.model;

import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseOutput {
    double result;
    Date date;
}

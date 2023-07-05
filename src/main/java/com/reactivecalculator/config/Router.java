package com.reactivecalculator.config;

import com.reactivecalculator.service.ReactiveCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {
    @Autowired
    ReactiveCalculatorService reactiveCalculatorService;

    @Bean
    RouterFunction<ServerResponse> serverResponseRouterFunction() {
        return RouterFunctions.route()
                .POST("reactive/calculator/add", reactiveCalculatorService::add)
                .POST("reactive/calculator/subtract", reactiveCalculatorService::sub)
                .POST("reactive/calculator/multiply", reactiveCalculatorService::mul)
                .POST("reactive/calculator/divide", reactiveCalculatorService::div)
                .POST("reactive/calculator/factorial", reactiveCalculatorService::factorial)
                .POST("reactive/calculator/table", reactiveCalculatorService::table)
                .build();
    }
}

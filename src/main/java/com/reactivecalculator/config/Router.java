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
        return RouterFunctions.route().path("reactive", this::getServerResponseRouterFunction).build();
    }

    private RouterFunction<ServerResponse> getServerResponseRouterFunction() {
        return RouterFunctions.route()
                .POST("/calculator/add", reactiveCalculatorService::add)
                .POST("/calculator/subtract", reactiveCalculatorService::sub)
                .POST("/calculator/multiply", reactiveCalculatorService::mul)
                .POST("/calculator/divide", reactiveCalculatorService::div)
                .POST("/calculator/factorial", reactiveCalculatorService::factorial)
                .POST("/calculator/table", reactiveCalculatorService::table)
                .build();
    }
}

package com.reactivecalculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient buildClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader("Content-type","application/json")
                .filter(this::useTokenBasedOnAttribute).build();
    }

    private Mono<ClientResponse> useTokenBasedOnAttribute(ClientRequest clientRequest, ExchangeFunction exchangeFunction) {
        if (clientRequest.attributes().get("auth").toString().equals("basic")) {
            clientRequest = ClientRequest.from(clientRequest).headers(h ->h.setBasicAuth("asadkhan","mypwd")).build();
        }else{
            clientRequest = ClientRequest.from(clientRequest).headers(h -> h.setBearerAuth("sometoken")).build();
        }
        return exchangeFunction.exchange(clientRequest);
    }


}

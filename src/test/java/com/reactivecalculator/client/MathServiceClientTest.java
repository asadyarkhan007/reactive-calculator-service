package com.reactivecalculator.client;

import com.reactivecalculator.BaseTest;
import com.reactivecalculator.model.RequestSingleInput;
import com.reactivecalculator.model.RequestTwoInput;
import com.reactivecalculator.model.ResponseOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class MathServiceClientTest extends BaseTest {


    @Autowired
    WebClient webClient;
    @Test
    void testAddReactiveMethod(){
        Mono<ResponseOutput> responseOutputMono = webClient.post().uri("reactive/calculator/add")
                .attribute("auth","basic")
                .bodyValue(RequestTwoInput.builder().num1(1).num2(2).build()).retrieve().bodyToMono(ResponseOutput.class)
                .doOnNext(x -> System.out.println(x.getResult()));

        StepVerifier.create(responseOutputMono).expectNextMatches(x -> x.getResult() ==3).verifyComplete();
    }
    @Test
    void testSubtractReactiveMethod(){
        Mono<ResponseOutput> responseOutputMono = webClient.post().uri("reactive/calculator/subtract")
                .attribute("auth","basic")
                .bodyValue(RequestTwoInput.builder().num1(4).num2(2).build()).retrieve().bodyToMono(ResponseOutput.class)
                .doOnNext(x -> System.out.println(x.getResult()));

        StepVerifier.create(responseOutputMono).expectNextMatches(x -> x.getResult() ==2).verifyComplete();
    }
    @Test
    void testDivideReactiveMethod(){
        Mono<ResponseOutput> responseOutputMono = webClient.post().uri("reactive/calculator/divide")
                .attribute("auth","bearer")
                .bodyValue(RequestTwoInput.builder().num1(4).num2(2).build()).retrieve().bodyToMono(ResponseOutput.class)
                .doOnNext(x -> System.out.println(x.getResult()));

        StepVerifier.create(responseOutputMono).expectNextMatches(x -> x.getResult() ==2).verifyComplete();
    }
    @Test
    void testMultiplyReactiveMethod(){
        Mono<ResponseOutput> responseOutputMono = webClient.post().uri("reactive/calculator/multiply")
                .attribute("auth","basic")
                .bodyValue(RequestTwoInput.builder().num1(1).num2(2).build()).retrieve().bodyToMono(ResponseOutput.class)
                .doOnNext(x -> System.out.println(x.getResult()));

        StepVerifier.create(responseOutputMono).expectNextMatches(x -> x.getResult() ==2).verifyComplete();
    }

    @Test
    void testTableReactiveMethod(){
        Flux<ResponseOutput> responseOutputFlux = webClient.post().uri("reactive/calculator/table")
                .attribute("auth","basic")
                .bodyValue(new RequestSingleInput(5)).retrieve().bodyToFlux(ResponseOutput.class)
                .doOnNext(x -> System.out.println(x.getResult()));

        StepVerifier.create(responseOutputFlux).expectNextCount(10).verifyComplete();
    }

    @Test
    void testFactorialReactiveMethodWhenHavingException(){
        Flux<ResponseOutput> responseOutputFlux = webClient.post().uri("reactive/calculator/factorial")
                .attribute("auth","basic")
                .bodyValue(new RequestSingleInput(25)).retrieve().bodyToFlux(ResponseOutput.class)
                .doOnNext(x -> System.out.println(x.getResult()));

        StepVerifier.create(responseOutputFlux).expectError();
    }

    @Test
    void testFactorialReactiveMethod(){
        Flux<ResponseOutput> responseOutputFlux = webClient.post().uri("reactive/calculator/factorial")
                .attribute("auth","basic")
                .bodyValue(new RequestSingleInput(5)).retrieve().bodyToFlux(ResponseOutput.class)
                .doOnNext(x -> System.out.println(x.getResult()));

        StepVerifier.create(responseOutputFlux).expectComplete();
    }
}

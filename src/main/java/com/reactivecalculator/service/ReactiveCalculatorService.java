package com.reactivecalculator.service;

import com.reactivecalculator.model.FactorialDto;
import com.reactivecalculator.model.RequestSingleInput;
import com.reactivecalculator.model.RequestTwoInput;
import com.reactivecalculator.model.ResponseOutput;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
public record ReactiveCalculatorService() {

    public Mono<ServerResponse> add(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(RequestTwoInput.class)
                .flatMap(requestTwoInput -> ServerResponse.ok()
                        .bodyValue(ResponseOutput.builder()
                                .result(requestTwoInput.getNum1() + requestTwoInput.getNum2())
                                .build())
                );
    }

    public Mono<ServerResponse> sub(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(RequestTwoInput.class)
                .flatMap(requestTwoInput -> ServerResponse.ok()
                        .bodyValue(ResponseOutput.builder()
                                .result(requestTwoInput.getNum1() - requestTwoInput.getNum2())
                                .build())
                );
    }

    public Mono<ServerResponse> div(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(RequestTwoInput.class)
                .flatMap(requestTwoInput -> ServerResponse.ok()
                        .bodyValue(ResponseOutput.builder()
                                .result(requestTwoInput.getNum1() / requestTwoInput.getNum2())
                                .build())
                );
    }

    public Mono<ServerResponse> mul(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(RequestTwoInput.class)
                .flatMap(requestTwoInput -> ServerResponse.ok()
                        .bodyValue(ResponseOutput.builder()
                                .result(requestTwoInput.getNum1() * requestTwoInput.getNum2())
                                .build())
                );
    }

    public Mono<ServerResponse> factorial(ServerRequest serverRequest) {

        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(
                        serverRequest.bodyToMono(RequestSingleInput.class)
                                .flatMapMany(val -> getFactorialFlux(new RequestSingleInput(val.getNum1()))
                        ), ResponseOutput.class);
    }


    public Mono<ServerResponse> table(ServerRequest serverRequest) {

        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(serverRequest.bodyToMono(RequestSingleInput.class).flatMapMany(requestSingleInput -> Flux.range(1, 10).delayElements(Duration.ofSeconds(1))
                .map(i -> ResponseOutput.builder().date(new Date()).result(i * requestSingleInput.getNum1()).build())), ResponseOutput.class );

    }

    private Flux<ResponseOutput> getFactorialFlux(RequestSingleInput requestSingleInput) {
        return Flux.generate(() -> FactorialDto.builder().counter((int) requestSingleInput.getNum1()).factValue(requestSingleInput.getNum1()).build(), (factorial, synchronousSink) -> {
            if (factorial.getCounter() <= 1) {
                synchronousSink.next(ResponseOutput.builder().result(factorial.getFactValue()).date(new Date()).build());
                synchronousSink.complete();
            } else {
                factorial.setFactValue(factorial.getFactValue() * (factorial.getCounter() -1));
                synchronousSink.next(ResponseOutput.builder().result(factorial.getFactValue()).date(new Date()).build());
            }
            factorial.setCounter(factorial.getCounter()-1);
            return factorial;
        }).delayElements(Duration.ofSeconds(1)).map(x -> (ResponseOutput) x);
    }

}

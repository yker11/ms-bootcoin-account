package com.proyfinal.msbootcoinaccount.handler;

import com.proyfinal.msbootcoinaccount.model.BootCoinAccount;
import com.proyfinal.msbootcoinaccount.model.dto.BootCoinAccountDto;
import com.proyfinal.msbootcoinaccount.service.IBootCoinAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class BootCoinAccountHandler {

    @Autowired
    private IBootCoinAccountService serviceBCA;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(serviceBCA.findAll(), BootCoinAccountDto.class);
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest){

        String id = serverRequest.pathVariable("id");

        return serviceBCA.findById(id)
                .flatMap(fby -> ServerResponse.status(HttpStatus.FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(fby))
                .onErrorResume(e -> Mono.just("Error de ID " + e.getMessage())
                        .flatMap(fby -> ServerResponse.status(HttpStatus.FOUND)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(fby)));
    }

    public Mono<ServerResponse> create(ServerRequest serverRequest){

        Mono<BootCoinAccount> bootCoinAccount = serverRequest.bodyToMono(BootCoinAccount.class);

        return bootCoinAccount.flatMap(c -> {
                    ServerResponse.status(HttpStatus.FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(c);
                    return serviceBCA.save(c)
                            .flatMap(s -> ServerResponse
                            .status(HttpStatus.CREATED)
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(s));

        });
    }
}

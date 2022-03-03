package com.proyfinal.msbootcoinaccount.service;

import com.proyfinal.msbootcoinaccount.model.BootCoinAccount;
import com.proyfinal.msbootcoinaccount.model.dto.BootCoinAccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootCoinAccountService {

    Flux<BootCoinAccountDto> findAll();

    Mono<BootCoinAccountDto> findById(String id);

    Mono<BootCoinAccountDto> save(BootCoinAccount bootCoinAccount);

    Mono<BootCoinAccountDto> getBootCoinDto(BootCoinAccount bootCoinAccount);

    Mono<BootCoinAccount> getBootCoin(BootCoinAccountDto bootCoinAccountDto);
}

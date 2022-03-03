package com.proyfinal.msbootcoinaccount.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyfinal.msbootcoinaccount.model.BootCoinAccount;
import com.proyfinal.msbootcoinaccount.model.dto.BootCoinAccountDto;
import com.proyfinal.msbootcoinaccount.repository.IBootCoinAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCoinAccountServiceImpl implements IBootCoinAccountService {

    @Autowired
    private IBootCoinAccountRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Flux<BootCoinAccountDto> findAll() {
        return repository.findAll()
                .flatMap(this::getBootCoinDto);
    }

    @Override
    public Mono<BootCoinAccountDto> findById(String id) {
        return repository.findById(id)
                .flatMap(this::getBootCoinDto);
    }

    @Override
    public Mono<BootCoinAccountDto> save(BootCoinAccount bootCoinAccount) {
        return repository.save(bootCoinAccount)
                .flatMap(this::getBootCoinDto);
    }

    @Override
    public Mono<BootCoinAccountDto> getBootCoinDto(BootCoinAccount bootCoinAccount) {
        return Mono.just(objectMapper.convertValue(bootCoinAccount, BootCoinAccountDto.class));
    }

    @Override
    public Mono<BootCoinAccount> getBootCoin(BootCoinAccountDto bootCoinAccountDto) {
        return Mono.just(objectMapper.convertValue(bootCoinAccountDto, BootCoinAccount.class));
    }
}

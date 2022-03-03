package com.proyfinal.msbootcoinaccount.repository;

import com.proyfinal.msbootcoinaccount.model.BootCoinAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBootCoinAccountRepository extends ReactiveMongoRepository<BootCoinAccount, String> {
}

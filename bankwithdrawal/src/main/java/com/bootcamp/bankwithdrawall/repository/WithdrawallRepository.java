package com.bootcamp.bankwithdrawall.repository;

import com.bootcamp.bankwithdrawall.bean.Withdrawall;
import com.bootcamp.bankwithdrawall.dto.WithdrawallDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

@Configuration
public interface WithdrawallRepository extends ReactiveMongoRepository<Withdrawall, String> {


    /*Mono<WithdrawallDto> findByName(String name);*/
    Mono<WithdrawallDto> findByWithdrawallNumber(String withdrawallNumber);
}

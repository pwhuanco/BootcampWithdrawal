package com.bootcamp.bankwithdrawall.service;

import com.bootcamp.bankwithdrawall.dto.WithdrawallDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WithdrawallService {

    Flux<WithdrawallDto> getWithdrawall();
    Mono<WithdrawallDto> getWithdrawallById(String id);

    //Mono<WithdrawallDto> getWithdrawallByName(String name);

    Mono<WithdrawallDto> getWithdrawallByWithdrawallNumber(String withdrawallNumber);

    Mono<WithdrawallDto> saveWithdrawall(Mono<WithdrawallDto> withdrawallDtoMono);

    Mono<WithdrawallDto> updateWithdrawall(Mono<WithdrawallDto> withdrawallDtoMono,String id);

    Mono<Void> deleteWithdrawall(String id);
}

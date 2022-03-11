package com.bootcamp.bankwithdrawall.service;

import com.bootcamp.bankwithdrawall.dto.WithdrawallDto;
import com.bootcamp.bankwithdrawall.repository.WithdrawallRepository;
import com.bootcamp.bankwithdrawall.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WithdrawallServiceImpl implements WithdrawallService {





    @Autowired
    private WithdrawallRepository withdrawallRepository;

    public Flux<WithdrawallDto> getWithdrawall() {
        return withdrawallRepository.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<WithdrawallDto> getWithdrawallById(String id) {
        return withdrawallRepository.findById(id).map(AppUtils::entityToDto);
    }
/*
    @Override
    public Mono<WithdrawallDto> getWithdrawallByName(String name) {
        return withdrawallRepository.findByName(name);
    }*/

    @Override
    public Mono<WithdrawallDto> getWithdrawallByWithdrawallNumber(String withdrawallNumber) {
        return withdrawallRepository.findByWithdrawallNumber(withdrawallNumber)
                .switchIfEmpty(Mono.just(WithdrawallDto.builder()
                        .withdrawallNumber(null).build()));
    }


    public Mono<WithdrawallDto> saveWithdrawall(Mono<WithdrawallDto> WithdrawallDtoMono) {
        return WithdrawallDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(withdrawallRepository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<WithdrawallDto> updateWithdrawall(Mono<WithdrawallDto> WithdrawallDtoMono, String id) {
        return withdrawallRepository.findById(id)
                .flatMap(p -> WithdrawallDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(withdrawallRepository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteWithdrawall(String id) {
        return withdrawallRepository.deleteById(id);
    }
}

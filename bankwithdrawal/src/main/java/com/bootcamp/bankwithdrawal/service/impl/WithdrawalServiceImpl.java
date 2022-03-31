package com.bootcamp.bankwithdrawal.service.impl;

import com.bootcamp.bankwithdrawal.dto.WithdrawalDto;
import com.bootcamp.bankwithdrawal.repository.WithdrawalRepository;
import com.bootcamp.bankwithdrawal.service.WithdrawalService;
import com.bootcamp.bankwithdrawal.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class WithdrawalServiceImpl implements WithdrawalService {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    public Flux<WithdrawalDto> getWithdrawal() {
        return withdrawalRepository.findAll().map(AppUtils::entityToDto);
    }

    @Override
    public Mono<WithdrawalDto> getWithdrawalById(String id) {
        return withdrawalRepository.findById(id).map(AppUtils::entityToDto);
    }

    @Override
    public Mono<WithdrawalDto> getWithdrawalByWithdrawalNumber(String withdrawalNumber) {
        return withdrawalRepository.findByWithdrawalNumber(withdrawalNumber)
                .switchIfEmpty(Mono.just(new WithdrawalDto()));
    }


    public Mono<WithdrawalDto> saveWithdrawal(Mono<WithdrawalDto> WithdrawalDtoMono) {
        return WithdrawalDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(withdrawalRepository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<WithdrawalDto> updateWithdrawal(Mono<WithdrawalDto> WithdrawalDtoMono, String id) {
        return withdrawalRepository.findById(id)
                .flatMap(p -> WithdrawalDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(withdrawalRepository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteWithdrawal(String id) {
        return withdrawalRepository.deleteById(id);
    }
}

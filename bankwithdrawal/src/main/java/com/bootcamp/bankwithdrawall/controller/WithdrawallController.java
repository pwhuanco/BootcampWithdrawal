package com.bootcamp.bankwithdrawall.controller;

import com.bootcamp.bankwithdrawall.dto.WithdrawallDto;
import com.bootcamp.bankwithdrawall.service.WithdrawallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Slf4j
@RestController
@RequestMapping(path = "/api/withdrawalls")
public class WithdrawallController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithdrawallController.class);

    @Autowired
    private WithdrawallService withdrawallService;

    @GetMapping
    public Flux<WithdrawallDto> getWithdrawall(){
        //log.debug("valor:{0}","ddddd");
        LOGGER.debug("Getting Withdrawalls!");
        return withdrawallService.getWithdrawall();
    }

    @GetMapping("/{id}")
    public Mono<WithdrawallDto> getWithdrawall(@PathVariable String id){
        LOGGER.debug("Getting a withdrawalls!");
        return withdrawallService.getWithdrawallById(id);
    }

    @PostMapping
    public Mono<WithdrawallDto> saveWithdrawall(@RequestBody Mono<WithdrawallDto> withdrawallDtoMono){
        LOGGER.debug("Saving clients!");
        return withdrawallService.saveWithdrawall(withdrawallDtoMono);
    }

    @PutMapping("/{id}")
    public Mono<WithdrawallDto> updateWithdrawall(@RequestBody Mono<WithdrawallDto> withdrawallDtoMono,@PathVariable String id){
        LOGGER.debug("Updating withdrawalls!");
        return withdrawallService.updateWithdrawall(withdrawallDtoMono,id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteWithdrawall(@PathVariable String id){
        LOGGER.debug("Deleting withdrawalls!");
        return withdrawallService.deleteWithdrawall(id);
    }

}

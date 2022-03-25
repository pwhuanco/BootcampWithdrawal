package com.bootcamp.bankwithdrawal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WithdrawalDto {
    private String id;
    private String balance;
    private String currency;
    private String idClient;
    private String fromAccountId;
    private String fromAccountNumber;
    private String toAccountId;
    private String toAccountNumber;
    private String withdrawalNumber;
    private String timestamp;

}

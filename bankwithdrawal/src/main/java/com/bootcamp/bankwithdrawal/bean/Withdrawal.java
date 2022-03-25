package com.bootcamp.bankwithdrawal.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("withdrawal")
@Data
public class Withdrawal {
    @Id
    private String id;
    private Double amount;
    private String currency;
    private String idClient;
    private String fromAccountId;
    private String fromAccountNumber;
    private String toAccountId;
    private String toAccountNumber;
    private String withdrawalNumber;
    private String timestamp;

}

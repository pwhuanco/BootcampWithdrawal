package com.bootcamp.bankwithdrawall.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("withdrawall")
@Data
public class Withdrawall {
	@Id
	private String id;
	private String balance;
	private String currency;
	private String idClient;
	private String withdrawallNumber;
	private String typeSavingAcc;
	private String typeCurrentAcc;
	private String typeTermAcc;

}

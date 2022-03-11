package com.bootcamp.bankwithdrawall.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WithdrawallDto {
	private String id;
	private String balance;
	private String currency;
	private String idClient;
	private String withdrawallNumber;
	private String typeSavingAcc;
	private String typeCurrentAcc;
	private String typeTermAcc;

}

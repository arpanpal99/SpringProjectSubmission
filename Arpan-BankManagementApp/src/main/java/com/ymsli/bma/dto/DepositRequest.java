package com.ymsli.bma.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepositRequest {
	
	@NotNull(message="Account Id should not be blank")
	private Integer accountId;
	
	@NotNull(message="Amount should not be blank")
	@Min(value=10, message="Transaction must be of atleast 10")
	@Max(value=1000000, message="Transaction must not be greater than 1000000")
	private Double amount;
}

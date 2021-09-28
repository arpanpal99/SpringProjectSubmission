package com.ymsli.bma.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString(exclude = "account")
@Table(name = "transaction_table")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer txId;
	private Integer txFromAccountId;
	private Integer txToAccountId;
	private String txType; // CREDIT, DEBIT
	private Double txAmount;
	private String txStatus; // PENDING, SUCCESSFULL, REJECTED

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_fk")
	private Account account;

	public Transaction(	Integer txFromAccountId, 
						Integer txToAccountId, 
						String txType, 
						Double txAmount,
						String txStatus) {
		
		this.txFromAccountId = txFromAccountId;
		this.txToAccountId = txToAccountId;
		this.txType = txType;
		this.txAmount = txAmount;
		this.txStatus = txStatus;
	}

	

}

package com.ymsli.bma.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString(exclude = {"customer", "txList"})
@Table(name = "account_table")
public class Account {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accId;
	private Double accBalance;
	
	@JoinColumn(name = "custid_fk")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Customer customer;

	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Transaction> txList = new ArrayList<>();
	
	public Account(Double accBalance) { 
		this.accBalance = accBalance; 
	}
	
}

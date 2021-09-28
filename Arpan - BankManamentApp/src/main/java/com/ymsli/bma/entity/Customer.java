package com.ymsli.bma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString(exclude = {"acc"})
@Table(name = "customer_table")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	
	@Column(unique = true)
	private String custName;
	@Column(unique = true)
	private String custEmail;
	@Column(unique = true)
	private String custContact;
	private String custAddress;
	
	@OneToOne
	private Account acc;
	
	public Customer(String custName, String custEmail, String custContact, String custAddress) {
		this.custName = custName;
		this.custEmail = custEmail;
		this.custContact = custContact;
		this.custAddress = custAddress;
	}
	
}

package com.ymsli.bma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymsli.bma.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Customer findByCustName(String custName);
	public Customer findByCustEmail(String custEmail);
	public Customer findByCustContact(String custContact);
	
}

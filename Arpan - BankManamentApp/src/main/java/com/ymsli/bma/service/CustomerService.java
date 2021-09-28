package com.ymsli.bma.service;

import java.util.List;

import com.ymsli.bma.entity.Customer;

public interface CustomerService {

	// CREATE
	public Customer addCustomer(Customer customer);

	// READ
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(Integer custId);
	public Customer getCustomerByName(String custName);

	// UPDATE
	public Customer updateCustomer(Integer custId, String custAddress);
	
	// DELETE
	public boolean deleteCustomer(Integer custId);
	public boolean deleteAllCustomers();
	

}

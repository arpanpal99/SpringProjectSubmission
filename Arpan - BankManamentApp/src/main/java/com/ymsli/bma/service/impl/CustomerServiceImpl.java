package com.ymsli.bma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymsli.bma.entity.Account;
import com.ymsli.bma.entity.Customer;
import com.ymsli.bma.exceptions.CustomerNotFoundException;
import com.ymsli.bma.repository.AccountRepository;
import com.ymsli.bma.repository.CustomerRepository;
import com.ymsli.bma.service.AccountService;
import com.ymsli.bma.service.CustomerService;
import com.ymsli.bma.service.TransactionService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService txService;

	// CREATE =============================================================================================
	@Override
	public Customer addCustomer(Customer customer) {
		return this.custRepo.save(customer);
	}

	// READ ===============================================================================================
	@Override
	public List<Customer> getAllCustomers() {
		return this.custRepo.findAll();
	}

	@Override
	public Customer getCustomerById(Integer custId) {
		return this.custRepo.findById(custId)
				.orElseThrow(() -> 
				new CustomerNotFoundException("Customer not found with id: " + custId));
	}

	@Override
	public Customer getCustomerByName(String custName) {
		return this.custRepo.findByCustName(custName);
	}

	// UPDATE ==============================================================================================
	@Override
	public Customer updateCustomer(Integer custId, String custAddress) {
		Customer existingCustomer = getCustomerById(custId);
		existingCustomer.setCustAddress(custAddress);
		return this.custRepo.save(existingCustomer);
	}

	// DELETE ==============================================================================================
	@Override
	public boolean deleteCustomer(Integer custId) {
		Customer existingCustomer = getCustomerById(custId);
		Account account = existingCustomer.getAcc();
		if(account != null)
			this.accountService.deleteAccount(account.getAccId());
		this.custRepo.delete(existingCustomer);
		return true;
	}
	
	@Override
	public boolean deleteAllCustomers() {
		this.txService.deleteAllTransactions();
		this.accountService.deleteAllAccounts();
		this.custRepo.deleteAll();
		return true;
	}

}

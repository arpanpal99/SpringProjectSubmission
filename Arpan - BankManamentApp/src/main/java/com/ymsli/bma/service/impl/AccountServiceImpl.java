package com.ymsli.bma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ymsli.bma.entity.Account;
import com.ymsli.bma.entity.Customer;
import com.ymsli.bma.exceptions.AccountNotFoundException;
import com.ymsli.bma.repository.AccountRepository;
import com.ymsli.bma.repository.CustomerRepository;
import com.ymsli.bma.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accRepo;
	@Autowired
	private CustomerRepository custRepo;

	// CREATE =========================================================================================
	@Override
	public Account addAccount(Account account) {
		return this.accRepo.save(account);
	}

	// READ =========================================================================================
	@Override
	public List<Account> getAllAccounts() {
		return this.accRepo.findAll();
	}

	@Override
	public Account getAccountById(Integer accId) throws AccountNotFoundException {
		return this.accRepo.findById(accId)
				.orElseThrow(() -> 
				new AccountNotFoundException("Account not found with id: " + accId));
	}

	// UPDATE =========================================================================================
	@Override
	public Account updateAccount(Integer accId, Double addAccBalance) throws AccountNotFoundException {
		Account acc = getAccountById(accId);
		acc.setAccBalance(acc.getAccBalance() + addAccBalance);
		return this.accRepo.save(acc);
	}

	// DELETE =========================================================================================
	@Override
	public boolean deleteAccount(Integer accId) throws AccountNotFoundException {
		Account acc = getAccountById(accId);
		this.accRepo.delete(acc);
		return true;
	}

	@Override
	public boolean deleteAllAccounts() {
		this.accRepo.deleteAll();
		return true;
	}
}

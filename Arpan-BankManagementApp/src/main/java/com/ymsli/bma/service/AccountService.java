package com.ymsli.bma.service;

import java.util.List;

import com.ymsli.bma.entity.Account;
import com.ymsli.bma.exceptions.AccountNotFoundException;

public interface AccountService {

	// CREATE
	public Account addAccount(Account account);
	
	// READ
	public List<Account> getAllAccounts();
	public Account getAccountById(Integer accId) throws AccountNotFoundException;
	//public Account getAccountByCustId(Integer custId);
	
	// UPDATE
	public Account updateAccount(Integer accId, Double accBalance) throws AccountNotFoundException;
	
	// DELETE
	public boolean deleteAccount(Integer accId) throws AccountNotFoundException;
	public boolean deleteAllAccounts();
	
}

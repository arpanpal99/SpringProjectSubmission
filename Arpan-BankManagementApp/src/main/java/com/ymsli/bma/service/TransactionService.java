package com.ymsli.bma.service;

import java.util.List;

import com.ymsli.bma.entity.Transaction;


public interface TransactionService {

	// CREATE
	public Transaction addTransaction(Transaction transaction);
	
	// READ
	public Transaction 		 getTransactionById(int transactionId);
	public List<Transaction> getAllTransactions();
	public List<Transaction> getTransactionListByStatus(String status);
	public List<Transaction> getAccountStatement(Integer accountNumber);

	// UPDATE
	public Transaction updateTransaction(int transactionId, String status);
	
	// DELETE
	public void deleteAllTransactions();
	
	// VERIFICATION
	public void approvePendingTransaction(Integer transactionId);
	public void rejectPendingTransaction(Integer transactionId);

	// OPERATIONS
	public void transfer(Integer senderAccountId, Integer receiverAccountId, Double addAccBalance);
	public void deposit(Integer accId, Double addAccBalance);
	public void withdraw(Integer accId, Double addAccBalance);
	
	
}

package com.ymsli.bma.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymsli.bma.entity.Account;
import com.ymsli.bma.entity.Transaction;
import com.ymsli.bma.exceptions.InsufficientBalanceException;
import com.ymsli.bma.exceptions.TransactionNotFoundException;
import com.ymsli.bma.repository.TransactionRepository;
import com.ymsli.bma.service.AccountService;
import com.ymsli.bma.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	private AccountService accService;
	private TransactionRepository txRepo;
	
	@Autowired
	public TransactionServiceImpl(AccountService accService, TransactionRepository txRepo) {
		this.accService = accService;
		this.txRepo = txRepo;
	}

	// CREATE ==============================================================================================================
	@Override
	public Transaction addTransaction(Transaction transaction) {
		return this.txRepo.save(transaction);
	}

	// READ ================================================================================================================
	@Override
	public List<Transaction> getAllTransactions() {
		return this.txRepo.findAll();
	}
	
	@Override
	public Transaction getTransactionById(int transactionId) {
		return this.txRepo.findById(transactionId)
				.orElseThrow(() -> 
				new TransactionNotFoundException("Transaction not found"));
	}

	@Override
	public List<Transaction> getTransactionListByStatus(String status) {
		return this.txRepo.findByTxStatus(status);
	}

	@Override
	public List<Transaction> getAccountStatement(Integer accountNumber) {
		List<Transaction> debit = this.txRepo.findByTxFromAccountId(accountNumber); // DEBIT
		List<Transaction> credit = this.txRepo.findByTxToAccountId(accountNumber);	// CREDIT
		List<Transaction> result = new ArrayList<Transaction>();
		result.addAll(debit);
		result.addAll(credit);
		return result;
	}

	// UPDATE ==================================================================================================================
	@Override
	public Transaction updateTransaction(int transactionId, String status) {
		Transaction existingTx = getTransactionById(transactionId);
		existingTx.setTxStatus(status);
		return this.txRepo.save(existingTx);
	}

	// DELETE ==================================================================================================================
	@Override
	public void deleteAllTransactions() {
		this.txRepo.deleteAll();
		
	}
	// VERIFICATION ============================================================================================================
	@Override
	public void approvePendingTransaction(Integer transactionId) {
		Transaction tx = getTransactionById(transactionId);
		
		accService.updateAccount(tx.getTxFromAccountId(), tx.getTxAmount()*(-1));
		accService.updateAccount(tx.getTxToAccountId(), tx.getTxAmount());
		tx.setTxStatus("APPROVED");
	}

	@Override
	public void rejectPendingTransaction(Integer transactionId) {
		Transaction tx = getTransactionById(transactionId);
		tx.setTxStatus("REJECTED");
	}

	// OPERATIONS ===============================================================================================================
	@Override
	public void transfer(Integer senderAccountId, Integer receiverAccountId, Double amount) {
		
		Account senderAcc = this.accService.getAccountById(senderAccountId);
		
		if(senderAcc.getAccBalance() >= amount) {
			if(amount > 0 && amount <= 200000) {
				Transaction tx = new Transaction(senderAccountId, receiverAccountId, "TRANSFER (Debit)", amount, "SUCCESSFUL");
				accService.updateAccount(senderAccountId, amount * (-1));
				accService.updateAccount(receiverAccountId, amount);
				addTransaction(tx);
			}
			else if(amount > 200000) {
				Transaction tx = new Transaction(senderAccountId, receiverAccountId, "TRANSFER (Debit)", amount, "PENDING");
				addTransaction(tx);
			}
		} else {
			throw new InsufficientBalanceException("Sender Account with ID: " + senderAccountId + " doesn't have enough balance.");
		}
	}

	@Override
	public void deposit(Integer accId, Double addAccBalance) {
		Transaction tx = new Transaction(null, accId, "DEPOSIT (Credit)", addAccBalance, "SUCCESSFUL");
		accService.updateAccount(accId, addAccBalance);
		this.txRepo.save(tx);
		
	}

	@Override
	public void withdraw(Integer accId, Double amount) {
		Account acc = this.accService.getAccountById(accId);
		if(acc.getAccBalance() >= amount) {
			Transaction tx = new Transaction(accId, null, "WITHDRAW (Debit)", amount, "SUCCESSFUL");
			accService.updateAccount(accId, amount*(-1));
			this.txRepo.save(tx);
		} else {
			throw new InsufficientBalanceException("Account with ID: " + accId + " doesn't have enough balance.");
		}
	}

	

}








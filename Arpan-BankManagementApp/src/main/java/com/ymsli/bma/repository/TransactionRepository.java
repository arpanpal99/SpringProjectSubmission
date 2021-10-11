package com.ymsli.bma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ymsli.bma.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	public List<Transaction> findByTxStatus(String txStatus);
	public List<Transaction> findByTxFromAccountId(Integer txFromAccountId);
	public List<Transaction> findByTxToAccountId(Integer txToAccountId);
}

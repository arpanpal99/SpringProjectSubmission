package com.ymsli.bma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ymsli.bma.dto.DepositRequest;
import com.ymsli.bma.dto.TransferRequest;
import com.ymsli.bma.dto.WithdrawRequest;
import com.ymsli.bma.entity.Transaction;
import com.ymsli.bma.service.TransactionService;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	// DEPOSIT ===============================================================================
	@GetMapping("deposit")
	public String depositGetMethod(ModelMap map) {
		map.addAttribute("depositRequest", new DepositRequest());
		return "deposit";
	}

	@PostMapping("deposit")
	public String depositPostMethod(@Valid @ModelAttribute(value = "depositRequest") DepositRequest depositRequest, BindingResult result) {
		if(result.hasErrors()) {
			return "deposit";
		}
		this.transactionService.deposit(depositRequest.getAccountId(), depositRequest.getAmount());
		return "redirect:../transaction/showAllTransactions";
	}

	// WITHDRAW ===============================================================================
	@GetMapping("withdraw")
	public String withdrawGetMethod(ModelMap map) {
		map.addAttribute("withdrawRequest", new WithdrawRequest());
		return "withdraw";
	}

	@PostMapping("withdraw")
	public String withdrawPostMethod(@Valid @ModelAttribute(value = "withdrawRequest") 
									WithdrawRequest withdrawRequst,  BindingResult result) {
		if(result.hasErrors()) {
			return "withdraw";
		}
		this.transactionService.withdraw(withdrawRequst.getAccountId(), withdrawRequst.getAmount());
		return "redirect:../transaction/showAllTransactions";
	}

	
	// TRANSFER ===============================================================================
	@GetMapping("transfer")
	public String transferGet(ModelMap map) {
		map.addAttribute("transferRequest", new TransferRequest());
		return "transfer";
	}

	@PostMapping("transfer")
	public String transferPost(@Valid @ModelAttribute(value = "transferRequest") 
								TransferRequest transferRequest, BindingResult result) {
		if(result.hasErrors()) {
			return "transfer";
		}
		this.transactionService.transfer(transferRequest.getFromAccId(), transferRequest.getToAccId(), transferRequest.getAmount());
		return "redirect:../transaction/showAllTransactions";
	}
	
	// =========================================================================================================================
	
	@GetMapping("showAllTransactions")
	public String getAllTransaction(Model model) {
		model.addAttribute("transactions", transactionService.getAllTransactions());
		return "showAllTransactions";
	}

	
	@GetMapping("/pendingTransaction")
	public String getAllPendingTransaction(Model model) {
		model.addAttribute("transactions", transactionService.getTransactionListByStatus("PENDING"));
		return "pendingTransaction";
	}
	
	@GetMapping("/approveTransaction/{txId}")
	public String approveTransaction(@PathVariable Integer txId) {
		transactionService.approvePendingTransaction(txId);
		return "redirect:../showAllTransactions";
	}
	
	@GetMapping("/rejectTransaction/{txId}")
	public String rejectTransaction(@PathVariable Integer txId) {
		transactionService.rejectPendingTransaction(txId);
		return "redirect:../showAllTransactions";
	}
	@GetMapping("/accountStatement")
	public String getAccountStatement(@RequestParam (name="id")int id,Model model) {
		List<Transaction> accountStatement = transactionService.getAccountStatement(id);
		model.addAttribute("transactions", accountStatement);
		return "showAllTransactions";
	}

}

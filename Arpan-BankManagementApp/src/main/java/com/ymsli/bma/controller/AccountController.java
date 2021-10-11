package com.ymsli.bma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ymsli.bma.service.AccountService;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

	@Autowired
	private AccountService accService;
	
	// All Accounts ==========================================================================
	@GetMapping("allAccounts")
	public String getAllTransactions(ModelMap map) {
		map.addAttribute("accounts", accService.getAllAccounts());
		return "showAllAccounts";
	}
	
	
	
}

package com.ymsli.bma.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ymsli.bma.entity.Account;
import com.ymsli.bma.entity.Customer;
import com.ymsli.bma.service.AccountService;
import com.ymsli.bma.service.CustomerService;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/allCustomers")
	public String getAllCustomer(ModelMap model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "showAllCustomers";
	}

	// CREATE =========================================================================================
	@GetMapping("/addCustomer")
	public String addCustomerGet(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}

	@PostMapping("/addCustomer")
	public String addCustomerPost(Model model, @ModelAttribute Customer customer, HttpServletRequest request) {
		
		Double balance = Double.parseDouble(request.getParameter("accountBalance"));
		Account account = new Account(balance);
		customer.setAcc(account);
		account.setCustomer(customer);
		accountService.addAccount(account);
		customerService.addCustomer(customer);
		return "redirect:allCustomers";
	}

	@GetMapping("/add5Customers")
	public String addFiveCustomers() {
		
		Account acc1 = new Account(55000.0);
		Account acc2 = new Account(39000.0);
		Account acc3 = new Account(155000.0);
		Account acc4 = new Account(69500.0);
		Account acc5 = new Account(25490.0);
		
		Customer cust1 = new Customer("Henry", "henry@gmail.com", "9478365895", "Australia");
		Customer cust2 = new Customer("Michael", "michael@gmail.com", "9587418965", "Switzerland");
		Customer cust3 = new Customer("Drek", "drek@gmail.com", "8965556983", "Las Vegas");
		Customer cust4 = new Customer("Mary", "mary@gmail.com", "9826365895", "Colorado");
		Customer cust5 = new Customer("Gwen", "gwen@gmail.com", "9587458465", "Brazil");
		
		cust1.setAcc(acc1);
		cust2.setAcc(acc2);
		cust3.setAcc(acc3);
		cust4.setAcc(acc4);
		cust5.setAcc(acc5);
		
		acc1.setCustomer(cust1);
		acc2.setCustomer(cust2);
		acc3.setCustomer(cust3);
		acc4.setCustomer(cust4);
		acc5.setCustomer(cust5);
		
		accountService.addAccount(acc1);
		accountService.addAccount(acc2);
		accountService.addAccount(acc3);
		accountService.addAccount(acc4);
		accountService.addAccount(acc5);
		
		customerService.addCustomer(cust1);
		customerService.addCustomer(cust2);
		customerService.addCustomer(cust3);
		customerService.addCustomer(cust4);
		customerService.addCustomer(cust5);

		System.out.println("FIVE CUSTOMERS ADDED with linked accounts");
		return "redirect:allCustomers";
		
	}
	// UPDATE =========================================================================================
	/*
	@GetMapping("/addCustomer")
	public String addCustomerGet(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}

	@PostMapping("/addCustomer")
	public String addCustomerPost(Model model, @ModelAttribute Customer customer, HttpServletRequest request) {
		customerService.addCustomer(customer);
		return "redirect:allCustomers";
	}
	*/
	@GetMapping("/updateCustomer/{custId}")
	public String updateCustomerGet(Model model, @PathVariable int custId) {
		
		model.addAttribute("customer",customerService.getCustomerById(custId));
		return "updateCustomer";
	}
	
	@PostMapping("/updateCustomer/{custId}")
	public String updateCustomerPut(Model model, @ModelAttribute Customer customer) {
		customerService.updateCustomer(customer.getCustId(), customer.getCustAddress());
		return "redirect:../allCustomers";
	}
	

	@GetMapping("/deleteCustomer/{custId}")
	public String deleteCustomer(@PathVariable Integer custId) {
		customerService.deleteCustomer(custId);
		return "redirect:../allCustomers";
	}

	@GetMapping("/deleteAllCustomers")
	public String deleteAllCustomers() {
		customerService.deleteAllCustomers();
		return "redirect:allCustomers";
	}
}

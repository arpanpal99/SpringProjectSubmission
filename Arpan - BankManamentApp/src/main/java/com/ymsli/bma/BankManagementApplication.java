package com.ymsli.bma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ymsli.bma.entity.Employee;
import com.ymsli.bma.service.TransactionService;

@SpringBootApplication
public class BankManagementApplication implements CommandLineRunner {

	@Autowired
	private TransactionService txService; 
	
	public static void main(String[] args) {
		SpringApplication.run(BankManagementApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// Employee emp = new Employee("Arpan", "arpan123", "arpan@gmail.com", "8240498310", "MANAGER");
	}
}

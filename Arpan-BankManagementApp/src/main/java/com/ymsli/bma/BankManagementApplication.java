package com.ymsli.bma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ymsli.bma.entity.Employee;
import com.ymsli.bma.service.EmployeeService;
import com.ymsli.bma.service.TransactionService;

@SpringBootApplication
@EnableTransactionManagement
public class BankManagementApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService empService; 
	
	public static void main(String[] args) {
		SpringApplication.run(BankManagementApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
/*
Manager: John
Password: john123

Clerk: Tyler, Jimmy, Megan
Password: tyler123, jimmy123, megan123
*/
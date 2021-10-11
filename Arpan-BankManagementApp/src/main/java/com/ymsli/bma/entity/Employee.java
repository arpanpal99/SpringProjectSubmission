package com.ymsli.bma.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@Table(name = "employee_table")
public class Employee {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String empUsername;
	private String empPassword;
	private String empEmail;
	private String empContact;
	private String empRole; //MANAGER, CLERK
	
	public Employee(String empUsername, 
					String empPassword, 
					String empEmail, 
					String empContact, 
					String empRole) {
	
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.empEmail = empEmail;
		this.empContact = empContact;
		this.empRole = empRole;
	}
}

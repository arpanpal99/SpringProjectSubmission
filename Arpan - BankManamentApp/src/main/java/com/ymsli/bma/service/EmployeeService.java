package com.ymsli.bma.service;

import java.util.List;

import com.ymsli.bma.entity.Employee;


public interface EmployeeService {

	// CREATE
	public Employee addEmployee(Employee employee);
	
	// READ
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Integer empId);
	public Employee getEmployeeByUsername(String empUsername);
	
	// UPDATE
	public Employee updateEmployee(Integer empId, Employee emp);

	// DELETE
	public boolean deleteEmployee(Integer empId);
	public void deleteAllEmployees();

}

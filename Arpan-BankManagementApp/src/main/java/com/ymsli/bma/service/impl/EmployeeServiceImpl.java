package com.ymsli.bma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ymsli.bma.entity.Employee;
import com.ymsli.bma.exceptions.EmployeeNotFoundException;
import com.ymsli.bma.repository.EmployeeRepository;
import com.ymsli.bma.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository empRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	@Autowired
	private PasswordEncoder encoder;

	// CREATE =============================================================================================
	@Override
	public Employee addEmployee(Employee employee) {
		employee.setEmpPassword(encoder.encode(employee.getEmpPassword()));
		return this.empRepo.save(employee);
	}

	// READ ===============================================================================================
	@Override
	public List<Employee> getAllEmployees() {
		return this.empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		return this.empRepo.findById(empId).
				orElseThrow(() -> 
				new EmployeeNotFoundException("Employee not found with id: " + empId));
	}
	@Override
	public Employee getEmployeeByUsername(String empUsername) {
		return this.empRepo.findByEmpUsername(empUsername);
	}

	// UPDATE ==============================================================================================
	@Override
	public Employee updateEmployee(Integer empId, Employee emp) {
		Employee existingEmployee = this.empRepo.findById(empId)
									.orElseThrow(() ->
									new EmployeeNotFoundException("Employee not found with id: " + empId));
		existingEmployee.setEmpPassword(encoder.encode(emp.getEmpPassword()));
		existingEmployee.setEmpEmail(emp.getEmpEmail());
		existingEmployee.setEmpContact(emp.getEmpContact());
		existingEmployee.setEmpRole(emp.getEmpRole());
		return this.empRepo.save(existingEmployee);
	}

	// DELETE ==============================================================================================
	@Override
	public boolean deleteEmployee(Integer empId) {
		Employee existingEmployee = this.empRepo.findById(empId)
				.orElseThrow(() ->
				new EmployeeNotFoundException("Employee not found with id: " + empId));
		this.empRepo.delete(existingEmployee);
		return true;
	}

	@Override
	public void deleteAllEmployees() {
		this.empRepo.deleteAll();
	}


}

package com.ymsli.bma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymsli.bma.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByEmpUsername(String empUsername);
	public Employee findByEmpEmail(String empEmail);
	public List<Employee> findByEmpRole(String empRole);
	
}

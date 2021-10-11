package com.ymsli.bma.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ymsli.bma.entity.Customer;
import com.ymsli.bma.entity.Employee;
import com.ymsli.bma.service.EmployeeService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	private EmployeeService empService;

	@Autowired
	public void setempService(EmployeeService empService) {
		this.empService = empService;
	}

	@GetMapping("/showAllEmployees")
	public String showAllEmployees(Model model) {
		model.addAttribute("employees", empService.getAllEmployees());
		return "showAllEmployees";
	}

	@GetMapping("/addEmployee")
	public String addEmployeeGet(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployeePost(Model model,@ModelAttribute Employee emp) {
	
		Integer empId=emp.getEmpId();
		if(empId==null) {
			empService.addEmployee(emp);
		}
	
		return "redirect:showAllEmployees";
	}
	@GetMapping("/add4Employees")
	public String addFourEmployees() {
	
		Employee emp1 = new Employee("John", "john123", "john@gmail.com", "6523325415", "ROLE_MANAGER");
		Employee emp2 = new Employee("Tyler", "tyler123", "tyler@gmail.com", "9874545415", "ROLE_CLERK");
		Employee emp3 = new Employee("Jimmy", "jimmy123", "jimmy@gmail.com", "8569632145", "ROLE_CLERK");
		Employee emp4 = new Employee("Megan", "megan123", "megan@gmail.com", "9852145896", "ROLE_CLERK");
	
		empService.addEmployee(emp1);
		empService.addEmployee(emp2);
		empService.addEmployee(emp3);
		empService.addEmployee(emp4);
		
		return "redirect:showAllEmployees";
	}
	
	@GetMapping("/updateEmployee/{empId}")
	public String updateCustomerGet(Model model, @PathVariable Integer empId) {
		model.addAttribute("employee", empService.getEmployeeById(empId));
		return "updateEmployee";
	} 
	
	@PostMapping("/updateEmployee/{empId}")
	public String updateEmployeePut(Model model, @ModelAttribute Employee employee) {
		empService.updateEmployee(employee.getEmpId(), employee);
		return "redirect:../showAllEmployees";
	}
	
	@GetMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable Integer empId) {
		empService.deleteEmployee(empId);
		return "redirect:../showAllEmployees";
	}
	
	@GetMapping("/deleteAllEmployees")
	public String deleteAllEmployees() {
		empService.deleteAllEmployees();
		return "redirect:showAllEmployees";
	}
	
}

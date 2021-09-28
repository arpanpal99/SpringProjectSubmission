package com.ymsli.bma.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ymsli.bma.entity.Employee;
import com.ymsli.bma.service.EmployeeService;

@Controller
@RequestMapping("/clerk")
public class ClerkController {
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
}

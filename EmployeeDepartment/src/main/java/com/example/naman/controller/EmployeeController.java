package com.example.naman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.naman.entity.Employee;
import com.example.naman.service.EmployeeService;

@RestController
@RequestMapping("/api")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/department/{departmentName}")
	public List<Employee> getEmployeeyDepartment(@PathVariable String departmentName){
		return employeeService.getEmployeesByDepartment(departmentName);
			
	}
//	@GetMapping("/employees/projects")
//	public List<Employee> getAllEmployeeWithProject(){
//		return employeeService.getAllEmployeesWithProject();
//	}
	
	@GetMapping("/employees/dep")
	public List<Employee> finfEmpWithDep(){
		return employeeService.findEmployeewithDep();
	}
	
	
}

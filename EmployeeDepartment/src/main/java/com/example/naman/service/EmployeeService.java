package com.example.naman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naman.entity.Employee;
import com.example.naman.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployeesByDepartment(String departmentName){
		return employeeRepository.findEmployeesByDepartmentName(departmentName);
	}
	
//	public List<Employee> getAllEmployeesWithProject() {
//		return employeeRepository.findAllEmployeeWithProject();
//		
//	}
	
	public List<Employee> findEmployeewithDep(){
		return employeeRepository.findEmployee();
	}
	
	
}

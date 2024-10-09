package com.example.naman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.naman.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	// Inner Join Query
	@Query("SELECT e FROM Employee e INNER JOIN e.department d WHERE d.name = :departmentName")
	List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);
	
	// fetch all employees 	and their Projects (Even if not assigned)
	
//	@Query("select e from Employee e LEFT JOIN e.projects p") 
//	List<Employee> findAllEmployeeWithProject();
	
	
	@Query(nativeQuery = true, value = "select * from employees")
	List<Employee> findEmployee();

	
	
}




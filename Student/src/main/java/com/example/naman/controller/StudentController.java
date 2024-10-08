package com.example.naman.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.naman.entity.Student;
import com.example.naman.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public Student createStudent(@RequestBody Student student) {
//		System.out.println("Student Added");
		return studentService.saveStudent(student);	
		
	}
	
	// Get All Students;
	@GetMapping("/fetch")
	public List<Student> getAllStudents() {
		return studentService.getAllStudent();
	}
	
	// Get Student by Id;
	@GetMapping("/fetch/{id}")
	public Optional<Student> getStudentbyId(@PathVariable Long id) {
		return studentService.getStudentById(id);
		
	}
	
	// Update Student by Id
	@PutMapping("/update/{id}")
	public Student updateStuById(@RequestBody Student student,  @PathVariable Long id) {
		
		return studentService.updateStudentyId(student, id);
			
	}
	
	@DeleteMapping("/del/{id}")
	public String deleteStu(@PathVariable Long id) {
		studentService.deleteById(id);
		return "Student Deleted SuccessFully";
	}
}




package com.example.naman.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naman.entity.Student;
import com.example.naman.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	// save a Student
	public  Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}
	
	
	public List<Student> getAllStudent(){
		
		return studentRepository.findAll();
		
	}
	
	public Optional<Student> getStudentById(Long id) {
		
		return studentRepository.findById(id);
		
	}
	
	
	public Student updateStudentyId(Student student , Long id) {
		Student existedStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
		existedStudent.setName(student.getName());
		existedStudent.setEmail(student.getEmail());
		existedStudent.setCourse(student.getCourse());
		
		return studentRepository.save(existedStudent);
		
	}
	
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
		
	}

}

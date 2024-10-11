package com.example.naman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.naman.entity.Student;
import com.example.naman.repository.StudentRepository;

@SpringBootApplication
public class StudentApplication
{
	@Autowired
	StudentRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
		System.out.println("Hello");
	}

//	@Override
//	public void run(String... args) throws Exception {
//		repository.findByCourseStartsWith("sa").forEach(student -> {
//			printStudentName(student);
//		});
//		
//	}
//
//	private void printStudentName(Student student) {
//		System.out.println(student.getName());
//	}

}

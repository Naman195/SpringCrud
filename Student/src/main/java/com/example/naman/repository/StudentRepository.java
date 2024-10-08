package com.example.naman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.naman.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long>
{
	List<Student> findByCourseStartsWith(String course);
}

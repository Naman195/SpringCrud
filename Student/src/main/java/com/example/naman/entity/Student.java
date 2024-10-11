package com.example.naman.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "student", 
		uniqueConstraints = @UniqueConstraint(columnNames = { "id", "email"} )	
)
public class Student {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id()
	@Column(unique = true, updatable = false)
	private int id;
	@Column(nullable = false)
	@NotBlank()
	private String name;
	@Email(message = "Email should e Valid")
	@Column(unique = true) 
	private String email;
	private String course;
	
	
//	public Student() {
//		
//	}
//	
//	
//	
//	public Student(int id, String name, String email, String course) {
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.course = course;
//		
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	
}

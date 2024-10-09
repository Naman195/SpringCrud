package com.example.naman.entity;



import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Table(name = "employees")
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	private String name;
	private String position;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	@JsonIgnore
	private Department department;
	

//	@ManyToMany(mappedBy = "employees")
//	private Set<Project> projects;
//	
//	  @ManyToOne
//	   @JoinColumn(name = "department_id")
//	   private Department department;
//	
//	
//	@Column(name = "e_name")
//	private String name;
//	private String position;
//	
//	 @ManyToOne
//     private Department department;
//
//	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
//	 private List<Project> emails;
	
//	@ManyToMany(mappedBy = "employees")
//	private Set<Project> projects;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

//	public Set<Project> getProjects() {
//		return projects;
//	}
//
//	public void setProjects(Set<Project> projects) {
//		this.projects = projects;
//	}
//	
	
	
	
	

}

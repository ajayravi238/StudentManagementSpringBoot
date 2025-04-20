package com.example.learn.studentManagement.Bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String dept;
	private String mail;
	
	public int getId() {		return id;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public String getMail() {
		return mail;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Student(String name, String dept, String mail) {
		this.name = name;
		this.dept = dept;
		this.mail = mail;
	}
	
	public Student() {
		
	}
}

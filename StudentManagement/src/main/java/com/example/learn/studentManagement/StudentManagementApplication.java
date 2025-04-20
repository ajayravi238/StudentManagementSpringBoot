package com.example.learn.studentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
//		SpringApplication.run(StudentManagementApplication.class, args);
//		SpringApplication app = new SpringApplication(StudentManagementApplication.class);
//        app.run(args);
		System.out.println("Starting Application...");
        SpringApplication.run(StudentManagementApplication.class, args);
        System.out.println("Application Started Successfully!");
	}

}
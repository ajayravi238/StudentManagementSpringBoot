package com.example.learn.studentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

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
	
	@Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
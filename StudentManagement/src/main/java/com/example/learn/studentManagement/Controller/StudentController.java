package com.example.learn.studentManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.learn.studentManagement.Bean.Student;
import com.example.learn.studentManagement.Service.StudentService;


@RestController
@RequestMapping("/Student")
public class StudentController {
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return ResponseEntity.ok("Student deleted successfully.");
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		 Student savedStudent = studentService.saveStudent(student);
		 return ResponseEntity.ok(savedStudent);
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
}

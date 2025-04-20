package com.example.learn.studentManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.learn.studentManagement.Bean.Student;
import com.example.learn.studentManagement.Repository.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	//get all - findAll
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	// get by id - findById
	public Optional<Student> getStudentById(int id) {
		return studentRepository.findById(id);
	}
	// delete by id - deleteById
	public void deleteStudentById(int id) {
		if (!studentRepository.existsById(id)) {
	        throw new RuntimeException("Student not found with id: " + id);
	    }
	    studentRepository.deleteById(id);
	}
	// create student - save 
	public Student saveStudent(Student student) {
		return studentRepository.save(student); 	
	}
	// update student - 
	public Student updateStudent(int id, Student student) {
		Optional<Student> existingStudent = studentRepository.findById(id);
		if(existingStudent.isPresent()) {
			Student updatedStudent = existingStudent.get();
			updatedStudent.setName(student.getName());
			updatedStudent.setMail(student.getMail());
			updatedStudent.setDept(student.getDept());
			return studentRepository.save(updatedStudent);
		}
		return null;
	}
}
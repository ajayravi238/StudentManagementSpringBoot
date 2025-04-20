package com.example.learn.studentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.learn.studentManagement.Bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}

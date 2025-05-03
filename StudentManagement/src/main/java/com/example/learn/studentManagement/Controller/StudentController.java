package com.example.learn.studentManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.learn.studentManagement.Bean.Student;
import com.example.learn.studentManagement.Service.StudentService;



@Controller
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
	
	// Thymeleaf starts
	// List
	@GetMapping("/list")
    public String getStudentList(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student-list";
    }
	
	@GetMapping("/view/{id}")
	public String viewStudentById(@PathVariable int id, Model model) {
	    Optional<Student> student = studentService.getStudentById(id);
	    
	    if (student.isPresent()) {
	        model.addAttribute("student", student.get());
	        return "student-detail";
	    } else {
	        return "error";
	    }
	}
	
	// Show the delete form page
	@GetMapping("/delete")
	public String showDeletePage() {
	    return "delete-student"; // this returns delete-student.html
	}

	// Handle delete operation
	@PostMapping("/delete")
	public String deleteStudentByForm(@RequestParam int id, Model model) {
	    studentService.deleteStudentById(id);
	    model.addAttribute("message", "Student deleted successfully.");
	    return "redirect:/Student/list"; // After deleting, go back to the list page
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
	    model.addAttribute("student", new Student());
	    return "add-student";
	}

	@PostMapping("/add-form")
	public String addStudentFromForm(@ModelAttribute Student student) {
	    studentService.saveStudent(student);
	    return "redirect:/Student/list";
	}
	
	// Edit
	@GetMapping("/edit")
	public String showEditIdForm() {
	    return "edit-student-id";  // New page to input ID
	}

	@PostMapping("/edit")
	public String fetchStudentById(@RequestParam int id, Model model) {
	    Optional<Student> student = studentService.getStudentById(id);
	    if (student.isPresent()) {
	        model.addAttribute("student", student.get());
	        return "edit-student"; // show edit form
	    } else {
	        model.addAttribute("error", "Student not found!");
	        return "edit-student-id"; // back to ID input
	    }
	}

	@PostMapping("/update-form/{id}")
	public String updateStudentFromForm(@PathVariable int id, @ModelAttribute Student student) {
	    studentService.updateStudent(id, student);
	    return "redirect:/Student/list";
	}
	
	@Controller
	public class HomeController {

	    @GetMapping("/")
	    public String showLandingPage() {
	        return "landing"; // should match landing.html in templates
	    }
	}


}

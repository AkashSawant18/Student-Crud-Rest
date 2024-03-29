package com.student.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.*;
import com.student.entity.Student;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@PutMapping("/{id}")
	public Optional<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
		return studentService.updateStudent(id, updatedStudent);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}

}

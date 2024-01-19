package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.DAO.StudentRepository;
import com.student.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public Optional<Student> updateStudent(Long id, Student updatedStudent) {
		if (studentRepository.existsById(id)) {
			updatedStudent.setId(id);
			return Optional.of(studentRepository.save(updatedStudent));
		} else {
			return Optional.empty();
		}
	}

	public String deleteStudent(Long id) {
		if (studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return "Student with ID " + id + " deleted successfully.";
		} else {
			return "Student with ID " + id + " not found.";
		}
	}

}

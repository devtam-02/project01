package com.devTam.project01.Controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devTam.project01.Entity.Student;
import com.devTam.project01.Service.StudentService;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
	@GetMapping("/alo")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	@PostMapping("/test")
	public void registerNewStudents(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
}

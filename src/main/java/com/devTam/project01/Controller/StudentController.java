package com.devTam.project01.Controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devTam.project01.Entity.Student;
import com.devTam.project01.Service.StudentService;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin("http://localhost:3000/")
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
	@DeleteMapping(path="delete/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long id) {
		studentService.deleteStudent(id);
	}
	@GetMapping(path="get/{studentId}")
	public Student getStudentById(@PathVariable("studentId") Long id) {
		return studentService.getStudentById(id);
	}
	@PutMapping(path="/{studentId}")
	public void updateStudent(@PathVariable("studentId") Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		studentService.updateStudent(id, name, email);
	}
	@PutMapping(path="/put/{studentId}")
	public void updateStudentByBody(@PathVariable("studentId") Long id,
			@RequestBody Student std) {
		studentService.updateStudent(id, std.getName(), std.getEmail());
	}
	@GetMapping("/testThyme1")
	public String testGetStudents(Model model) throws Exception  {
		List<Student> std = studentService.getStudents();
		for (Student student : std) {
			System.out.println(student);
		}
		if (std != null)
			model.addAttribute("students",std);
		
		return "index";
	}
}

package com.devTam.project01.Service;

import java.time.LocalDate;
import java.time.Month;
//import java.util.List;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devTam.project01.Entity.Student;
import com.devTam.project01.Respository.StudentRepository;
@Component
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}



	public List<Student> getStudents() {
		return studentRepository.findAll();
	}



	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()){
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
		System.out.println(student);
	}
}

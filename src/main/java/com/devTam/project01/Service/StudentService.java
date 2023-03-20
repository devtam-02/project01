package com.devTam.project01.Service;

import java.time.LocalDate;
import java.time.Month;
//import java.util.List;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.devTam.project01.Entity.Student;
import com.devTam.project01.Respository.StudentRepository;

import jakarta.transaction.Transactional;
//@Component
@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}



	public List<Student> getStudents() {
		return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}



	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()){
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
		System.out.println(student);
	}



	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		boolean exits = studentRepository.existsById(id);
		if(!exits) {
			throw new IllegalStateException("student with id " + id + " does not exits");
		}
		studentRepository.deleteById(id);
	}


	@Transactional
	public void updateStudent(Long id, String name, String email) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exits")); 
		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
	}



	public Student getStudentById(Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exits")); 
		return student;
	}
}

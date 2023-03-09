package com.devTam.project01.Service;

import java.time.LocalDate;
import java.time.Month;
//import java.util.List;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devTam.project01.Entity.Student;
@Component
public class StudentService {
	public List<Student> getStudents() {
		return List.of(
				new Student(1L, 
						"Nguyen Trong Tam",
						"nguyentrongtam2x2@gmail.com",
						LocalDate.of(2000, Month.JANUARY, 5),
						21)
			);
	}
}

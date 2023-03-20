package com.devTam.project01.Config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devTam.project01.Entity.Student;
import com.devTam.project01.Respository.StudentRepository;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		repository.deleteAll();
		return args ->{
			Student tam = new Student(
					"Nguyen Trong Tam",
					"nguyentrongtam2x2@gmail.com",
					LocalDate.of(2000, Month.JANUARY, 5));
			Student nam = new Student(
					"Hoang Duc Nam",
					"namhoang22@gmail.com",
					LocalDate.of(2002, Month.JUNE, 3));
			
			repository.saveAll(List.of(tam,nam));
		};
	}
}

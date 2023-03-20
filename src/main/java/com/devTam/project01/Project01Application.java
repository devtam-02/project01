package com.devTam.project01;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devTam.project01.Entity.Student;

@SpringBootApplication
@RestController
public class Project01Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Project01Application.class, args);
	}
	
	@GetMapping("/")
	public String hello() {
		return "DMMMM";
	}
	

}

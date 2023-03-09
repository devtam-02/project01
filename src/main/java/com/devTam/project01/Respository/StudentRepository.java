package com.devTam.project01.Respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devTam.project01.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
}

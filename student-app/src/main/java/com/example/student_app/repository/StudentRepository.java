package com.example.student_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.student_app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);
}
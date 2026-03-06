package com.example.student_app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.student_app.dto.StudentRequestDTO;
import com.example.student_app.dto.StudentResponseDTO;

public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO request);

    StudentResponseDTO getStudentById(Long id);

    Page<StudentResponseDTO> getAllStudents(Pageable pageable);

    StudentResponseDTO updateStudent(Long id, StudentRequestDTO request);

    void deleteStudent(Long id);
}
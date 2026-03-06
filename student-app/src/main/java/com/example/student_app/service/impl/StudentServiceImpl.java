package com.example.student_app.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.student_app.dto.StudentRequestDTO;
import com.example.student_app.dto.StudentResponseDTO;
import com.example.student_app.entity.Student;
import com.example.student_app.exception.ResourceNotFoundException;
import com.example.student_app.repository.StudentRepository;
import com.example.student_app.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Student student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .course(request.getCourse())
                .build();

        Student saved = repository.save(student);

        return mapToResponse(saved);
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return mapToResponse(student);
    }

    @Override
    public Page<StudentResponseDTO> getAllStudents(Pageable pageable) {
        return repository.findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO request) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());
        student.setCourse(request.getCourse());

        return mapToResponse(repository.save(student));
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    private StudentResponseDTO mapToResponse(Student student) {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .course(student.getCourse())
                .build();
    }
}

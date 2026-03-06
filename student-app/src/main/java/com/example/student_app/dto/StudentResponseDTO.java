package com.example.student_app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponseDTO {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String course;
}
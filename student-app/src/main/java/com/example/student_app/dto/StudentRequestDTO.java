package com.example.student_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentRequestDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Min(value = 1, message = "Age must be a positive integer")
    private Integer age;

    private String course;
}

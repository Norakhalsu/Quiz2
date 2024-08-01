package com.example.quiz2_school.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotNull(message = "Id must be not null")
    private int id;

    @NotEmpty(message = "Name must be not empty ")
    private String name;

    @NotNull(message = " Age must not null ")
    private int age;

    @NotEmpty(message = " Major must not empty ")
    private String major;
}

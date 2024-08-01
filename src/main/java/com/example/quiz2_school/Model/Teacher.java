package com.example.quiz2_school.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotNull(message = " id require")
    private int id;
    @NotEmpty(message = " Name require ")
     private String name;
    @NotNull(message = " Salary require ")
     private int salary;

}


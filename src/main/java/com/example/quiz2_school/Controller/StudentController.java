package com.example.quiz2_school.Controller;


import com.example.quiz2_school.Model.Student;
import com.example.quiz2_school.Sercive.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get") // get all student
    public ArrayList<Student> getStudent() {
      return studentService.getStudents();
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student , Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(" Student Added Successfully");
    }


@PutMapping("/update/{id}")// update student
    public ResponseEntity updateStudent(@PathVariable int id ,@Valid @RequestBody Student student , Errors errors) {
        if(errors.hasErrors()) {
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean updateStudent=studentService.updateStudent(id,student);
        if (updateStudent){
            return ResponseEntity.status(200).body(" Student Updated Successfully"); // done Updated
        }
        return ResponseEntity.status(400).body(" Not find ID Student ");
}


@DeleteMapping("/delete/{id}")// delete student by id
    public ResponseEntity deleteStudent(@PathVariable int id) {

       // boolean deletedStudent = studentService.deleteStudent(id); // if Array is Empty

       if (studentService.deleteStudent(id)){
           return ResponseEntity.status(200).body(" Student Deleted Successfully");
       }
       return ResponseEntity.status(400).body(" Not find ID Student ");
    }


    @GetMapping("/name/{name}") // takes a student name and returns one student .

    public ResponseEntity getName(@PathVariable String name) {
              return ResponseEntity.status(201).body(studentService.getNameStudent(name));
    }


    @GetMapping("/major/{major}")//takes a major and returns all students who have this major.
    public ResponseEntity getMajor(@PathVariable String major) {
        ArrayList<Student> students=studentService.getStudents();
        if(students == null){
            return ResponseEntity.status(404).body(" No Student Found");
        }
            return ResponseEntity.status(200).body(students);
    }




}

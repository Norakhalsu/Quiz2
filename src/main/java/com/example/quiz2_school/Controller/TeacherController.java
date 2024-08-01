package com.example.quiz2_school.Controller;


import com.example.quiz2_school.Model.Teacher;
import com.example.quiz2_school.Sercive.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ArrayList<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

      @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher , Errors errors) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(" Teacher Added Successfully");
      }



      @PutMapping("/update/{id}")
     public ResponseEntity updateTeacher(@PathVariable int id, @Valid @RequestBody Teacher teacher , Errors errors) {

        if (teacherService.updateTeacher(id, teacher)){
            return ResponseEntity.status(200).body(" Teacher Updated Successfully");
        }
        return ResponseEntity.status(404).body(" Teacher Not Found");
      }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteTeacher(@PathVariable int id) {
        if (teacherService.deleteTeacher(id)){
            return ResponseEntity.status(200).body(" Teacher Deleted Successfully");
        }
            return ResponseEntity.status(404).body(" Teacher Not Found");
        }


        @GetMapping("/get-teacher/{id}") // takes a teacher id and returns one teacher .
        public ResponseEntity getTeacher(@PathVariable int id) {
         if (teacherService==null){
             return ResponseEntity.status(404).body(" Teacher Not Found");
         }
         return ResponseEntity.status(200).body(teacherService.getTeacher(id));
        }


        @GetMapping("/salary/{salary}") // takes a salary and return all teachers who have this salary or above .
        public ResponseEntity getSalary(@PathVariable int salary) {
        ArrayList<Teacher> teachers = teacherService.getTeachers();
       if (teachers==null){
           return ResponseEntity.status(404).body(" Teacher Not Found");
       }
        return ResponseEntity.status(200).body(teachers);
        }
}



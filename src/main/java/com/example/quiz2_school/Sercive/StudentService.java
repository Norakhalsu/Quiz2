package com.example.quiz2_school.Sercive;


import com.example.quiz2_school.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<Student>();

    // return all students
    public ArrayList<Student> getStudents() {
        return students;
    }

    // add new student
    public void addStudent(Student student) {
        students.add(student);
    }



    // update student
    public boolean updateStudent(int id , Student student) {
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                students.set(i, student);
                return true; //updated
            }
        }
        return false; // cannot find
    }


    // delete Student by id
    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;// deleted student
            }
        }
        return false;// not found

    }

   //  takes a student name and returns one student .
    public Student getNameStudent(String name ) {
          for (Student student : students) {
              if (student.getName().equals(name)) {
                  return student;
              }
          }
        return null;
    }

    // takes a major and returns all students who have this major.
    public ArrayList<Student> getMajorStudents(String Major) {
        ArrayList<Student> MajorStudents=new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equals(Major)) {
                MajorStudents.add(student);
                return MajorStudents;
            }
        }
        return null;
    }
}

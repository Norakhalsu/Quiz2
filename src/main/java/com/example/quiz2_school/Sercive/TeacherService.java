package com.example.quiz2_school.Sercive;


import com.example.quiz2_school.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<Teacher>();


    // get all teachers
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    // add new teacher
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

   // update teacher
    public boolean updateTeacher(int id  , Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.set(i, teacher);
                return true; // updated Teacher
            }
        } return false;
    }

  // delete teacher
    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

   //  takes a teacher id and returns one teacher
    public Teacher getTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
            return null;
    }


    // takes a salary and return all teachers who have this salary or above .
    public ArrayList<Teacher> getTeacherBySalary(int salary) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getSalary() == salary || teacher.getSalary() >= salary) {
                teachers.add(teacher);
                return teachers;
            }
        }
        return null;
    }


}




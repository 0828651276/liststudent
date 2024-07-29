package bai_tap.student_management.service.student_service;


import bai_tap.student_management.model.Student;

import java.util.ArrayList;

public interface IStudentService {
    ArrayList<Student> findAll();
    void addStudent(Student student);
    void updateStudent(String id,Student updateStudent);
    Student findStudentById(String id);
    boolean deleteStudent(String id);
}
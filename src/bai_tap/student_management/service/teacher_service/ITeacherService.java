package bai_tap.student_management.service.teacher_service;

import bai_tap.student_management.model.Teacher;

import java.util.ArrayList;

public interface ITeacherService {
    ArrayList<Teacher> findAll();
    void addTeacher(Teacher teacher);
    void updateTeacher(String id, Teacher updatedTeacher);
    Teacher findTeacherById(String id);
    boolean deleteTeacher(String id);
}
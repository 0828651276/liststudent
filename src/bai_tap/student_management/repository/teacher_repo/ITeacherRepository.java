package bai_tap.student_management.repository.teacher_repo;

import bai_tap.student_management.model.Teacher;

import java.util.ArrayList;

public interface ITeacherRepository {
    ArrayList<Teacher> findAll();
    void addTeacher(Teacher teacher);
    void updateTeacher(String id, Teacher updatedTeacher);
    Teacher findTeacherById(String id);
    void deleteTeacher(String id);
}
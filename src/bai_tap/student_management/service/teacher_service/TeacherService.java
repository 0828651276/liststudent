package bai_tap.student_management.service.teacher_service;

import bai_tap.student_management.model.Teacher;
import bai_tap.student_management.repository.teacher_repo.ITeacherRepository;
import bai_tap.student_management.repository.teacher_repo.TeacherRepository;

import java.util.ArrayList;

public class TeacherService implements ITeacherService {
    private final ITeacherRepository teacherRepo = new TeacherRepository();
    @Override
    public ArrayList<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepo.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(String id, Teacher updatedTeacher) {
        teacherRepo.updateTeacher(id, updatedTeacher);
    }

    @Override
    public Teacher findTeacherById(String id) {
        return teacherRepo.findTeacherById(id);
    }

    @Override
    public boolean deleteTeacher(String id) {
        teacherRepo.deleteTeacher(id);
        return true;
    }
}
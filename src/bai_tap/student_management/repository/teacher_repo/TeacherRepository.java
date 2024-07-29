package bai_tap.student_management.repository.teacher_repo;

import bai_tap.student_management.model.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;

public class TeacherRepository implements ITeacherRepository {
    private static ArrayList<Teacher> list;

    static {
        list = new ArrayList<>();
        Teacher t1 = new Teacher("1", "cong", LocalDate.parse("1988-02-01"), "cong1@gmail.com", "0123456788", "Giảng viên");
        Teacher t2 = new Teacher("2", "luan", LocalDate.parse("1998-02-06"), "luan2@gmail.com", "0123456778", "Giảng viên");
        Teacher t3 = new Teacher("1", "anh", LocalDate.parse("1993-02-01"), "anh3@gmail.com", "0123456678", "Giảng viên");
        Teacher t4 = new Teacher("2", "hoa", LocalDate.parse("1995-02-06"), "hoa4@gmail.com", "0123455678", "Giảng viên");
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
    }

    @Override
    public ArrayList<Teacher> findAll() {
        return list;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        list.add(teacher);
    }

    @Override
    public void updateTeacher(String id, Teacher updatedTeacher) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.set(i, updatedTeacher);
                return;
            }
        }
    }

    @Override
    public Teacher findTeacherById(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteTeacher(String id) {
        list.remove(findTeacherById(id));
    }
}
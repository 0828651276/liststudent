package bai_tap.student_management.repository.student_repo;

import bai_tap.student_management.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentRepository implements IStudentRepository {
    private static ArrayList<Student> list;

    static {
        list = new ArrayList<>();
        Student s1 = new Student("1", "chuyen", LocalDate.parse("2004-03-01"), "chuyen1@gmail.com", "0123456789", "C05");
        Student s2 = new Student("2", "tuan", LocalDate.parse("2002-07-01"), "tuan2@gmail.com", "0132456789", "C05");
        Student s3 = new Student("3", "long", LocalDate.parse("2000-05-01"), "long3@gmail.com", "0124356789", "C05");
        Student s4 = new Student("4", "ki", LocalDate.parse("2000-09-01"), "ki4@gmail.com", "0123546789", "C05");
        Student s5 = new Student("5", "duy", LocalDate.parse("2001-02-01"), "duy5@gmail.com", "0123465789", "C05");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
    }

    @Override
    public ArrayList<Student> findAll() {
        return list;
    }

    @Override
    public void addStudent(Student student) {
        list.add(student);

    }

    @Override
    public void updateStudent(String id, Student updatedStudent) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.set(i, updatedStudent);
                return;
            }
        }
    }

    @Override
    public Student findStudentById(String id) {
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId().equals(id)) {
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(String id) {
        list.remove(findStudentById(id));
    }
}

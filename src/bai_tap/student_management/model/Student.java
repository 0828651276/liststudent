package bai_tap.student_management.model;

import java.time.LocalDate;

public class Student extends Person {
    private String className;

    public Student() {

    }

    public Student(String id,String name, LocalDate birthDate, String email, String phoneNumber, String className) {
        super(id, name, birthDate, email, phoneNumber);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void learn(String subject) {
        System.out.println("Học môn " + subject);
    }

    @Override
    public void say() {
        System.out.println("Dear teacher .....");
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                '}' + super.toString();
    }
}

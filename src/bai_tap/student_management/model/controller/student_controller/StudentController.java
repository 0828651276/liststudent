package bai_tap.student_management.controller.student_controller;

import bai_tap.student_management.model.Student;
import bai_tap.student_management.service.student_service.IStudentService;
import bai_tap.student_management.service.student_service.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentController {
    private final IStudentService studentService = new StudentService();
    private final Scanner sc = new Scanner(System.in);

    public void display() {
        ArrayList<Student> students = studentService.findAll();
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    public void editStudent() {
        System.out.print("Nhập ID của học viên cần chỉnh sửa: ");
        String id = sc.nextLine();

        Student existingStudent = studentService.findStudentById(id);
        if (existingStudent == null) {
            System.out.println("Không tìm thấy học viên có ID là " + id);
            return;
        }
        System.out.println("Thông tin học viên cần chỉnh sửa:");
        System.out.println(existingStudent);

        int choice;
        do {
            System.out.println("Chọn thông tin cần chỉnh sửa: \n" +
                    "1. Tên. \n" +
                    "2. Ngày sinh. \n" +
                    "3. Email. \n" +
                    "4. Số điện thoại. \n" +
                    "5. Lớp. \n" +
                    "6. Hoàn thành. \n"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Tên mới:");
                    String newName = sc.nextLine();
                    if (newName != null) {
                        existingStudent.setName(newName);
                    }
                    break;
                case 2:
                    System.out.println("Ngày sinh mới:");
                    LocalDate newBirthday = LocalDate.parse(sc.nextLine());
                {
                    existingStudent.setBirthDate(newBirthday);
                }
                break;
                case 3:
                    System.out.println("Email mới:");
                    String newEmail = sc.nextLine();
                    if (newEmail != null) {
                        existingStudent.setEmail(newEmail);
                    }
                    break;
                case 4:
                    System.out.println("SĐT mới:");
                    String newPhoneNumber = sc.nextLine();
                    if (newPhoneNumber != null) {
                        existingStudent.setPhoneNumber(newPhoneNumber);
                    }
                    break;
                case 5:
                    System.out.println("Lớp mới:");
                    String newClassName = sc.nextLine();
                    if (newClassName != null) {
                        existingStudent.setClassName(newClassName);
                    }
                    break;
            }
        }
        while (choice != 6);
        studentService.updateStudent(id, existingStudent);
    }

    public void addStudent() {
        System.out.println("Nhập id");
        String id = sc.nextLine();
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập ngày sinh: ");
        LocalDate birthday = LocalDate.parse(sc.nextLine());
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập sdt: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập tên lớp: ");
        String className = sc.nextLine();

        Student student1 = new Student(id, name, birthday, email, phoneNumber, className);
        studentService.addStudent(student1);
    }

    public void deleteStudent() {
        System.out.print("Nhập ID của học viên cần xóa: ");
        String id = sc.nextLine();

        Student existingStudent = studentService.findStudentById(id);
        if (existingStudent == null) {
            System.out.println("Không tìm thấy học viên có ID là " + id);
            return;
        }
        System.out.println("Thông tin giảng vien cần xóa");
        System.out.println(existingStudent);
        if (studentService.deleteStudent(id)) {
            System.out.println("Xóa thành công");
        }
    }

    public void DisplayStudentFunctional() {
        int choice;
        do {
            System.out.println("Quản lý Codegym: \n" +
                    "1. Hiển thị danh sách học viên. \n" +
                    "2. Thêm mới học viên. \n" +
                    "3. Chỉnh sửa thông tin học viên. \n" +
                    "4. Xóa học viên. \n" +
                    "5. Go back menu. \n" +
                    "Xin chọn");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    display();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    return;


            }
        }
        while (true);
    }
}

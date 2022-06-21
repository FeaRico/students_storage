package ru.makhach.studentsstorage.dao;

import ru.makhach.studentsstorage.model.Student;

import java.util.List;

public interface StudentDao {
    String TABLE_NAME = "students";

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student deleteStudentById(Long id);

    Student addStudent(Student student);
}

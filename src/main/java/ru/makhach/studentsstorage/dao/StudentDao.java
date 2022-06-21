package ru.makhach.studentsstorage.dao;

import ru.makhach.studentsstorage.model.Student;
import ru.makhach.studentsstorage.ui.type.DeleteStatus;

import java.util.List;

public interface StudentDao {
    String TABLE_NAME = "students";

    List<Student> getAllStudents();

    DeleteStatus deleteStudentById(Long id);

    Student addStudent(Student student);
}

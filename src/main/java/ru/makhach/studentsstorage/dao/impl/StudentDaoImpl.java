package ru.makhach.studentsstorage.dao.impl;

import ru.makhach.studentsstorage.config.StudentsPostgresConnection;
import ru.makhach.studentsstorage.dao.StudentDao;
import ru.makhach.studentsstorage.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao {
    private final StudentsPostgresConnection studentsConnection;

    private static final String QUERY_ALL_STUDENTS = "SELECT * FROM " + TABLE_NAME;
    private static final String QUERY_ADD_STUDENT = "INSERT INTO" + TABLE_NAME + "(first_name, last_name, middle_name, group_name, age) VALUES(?, ?, ?, ?, ?)";

    public StudentDaoImpl() {
        this.studentsConnection = StudentsPostgresConnection.getInstance();
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Optional<Connection> optionalConnection = studentsConnection.getConnection();
        optionalConnection.ifPresent(connection -> {
            try {
                PreparedStatement statement = connection.prepareStatement(QUERY_ALL_STUDENTS);
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    Student student = Student.builder().id(rs.getLong("id"))
                            .firstName(rs.getString("first_name"))
                            .lastName(rs.getString("last_name"))
                            .middleName(rs.getString("middle_name"))
                            .group(rs.getString("group_name"))
                            .age(rs.getInt("age"))
                            .build();
                    students.add(student);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        return null;
    }

    @Override
    public Student deleteStudentById(Long id) {
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        Optional<Connection> optionalConnection = studentsConnection.getConnection();
        optionalConnection.ifPresent(connection -> {
            try {
                PreparedStatement statement = connection.prepareStatement(QUERY_ADD_STUDENT);
                statement.setString(1, student.getFirstName());
                statement.setString(2, student.getLastName());
                statement.setString(3, student.getMiddleName());
                statement.setString(4, student.getGroup());
                statement.setInt(5, student.getAge());
                statement.executeUpdate();
                statement.close();
                connection.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        return student;
    }
}

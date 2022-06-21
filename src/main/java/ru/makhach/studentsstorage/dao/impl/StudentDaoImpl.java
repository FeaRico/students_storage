package ru.makhach.studentsstorage.dao.impl;

import ru.makhach.studentsstorage.config.connect.postgresql.StudentsPostgresConnection;
import ru.makhach.studentsstorage.dao.StudentDao;
import ru.makhach.studentsstorage.model.Student;
import ru.makhach.studentsstorage.ui.type.DeleteStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class StudentDaoImpl implements StudentDao {
    private final StudentsPostgresConnection studentsConnection;

    private static final String QUERY_ALL_STUDENTS = "SELECT * FROM " + TABLE_NAME;
    private static final String QUERY_ADD_STUDENT = "INSERT INTO " + TABLE_NAME + "(first_name, last_name, middle_name, group_name, age) VALUES(?, ?, ?, ?, ?)";
    private static final String QUERY_DELETE_STUDENT = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

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
                ResultSet rs = statement.executeQuery();
                if (rs != null) {
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
                }
                statement.close();
                closeConnection(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                closeConnection(connection);
            }
        });
        return students;
    }

    @Override
    public DeleteStatus deleteStudentById(Long id) {
        AtomicInteger deletedRows = new AtomicInteger();
        AtomicReference<DeleteStatus> status = new AtomicReference<>();

        Optional<Connection> optionalConnection = studentsConnection.getConnection();
        optionalConnection.ifPresent(connection -> {
            try {
                PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_STUDENT);
                statement.setLong(1, id);
                deletedRows.set(statement.executeUpdate());
                statement.close();
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
                status.set(DeleteStatus.CONNECTION_ERROR);
                closeConnection(connection);
            }
        });
        if (deletedRows.get() == 0)
            status.set(DeleteStatus.NOT_FOUND_WITH_ID);
        else status.set(DeleteStatus.SUCCESS);

        return status.get();
    }

    @Override
    public Student addStudent(Student student) {
        Optional<Connection> optionalConnection = studentsConnection.getConnection();
        AtomicLong generatedId = new AtomicLong();
        optionalConnection.ifPresent(connection -> {
            try {
                PreparedStatement statement = connection.prepareStatement(QUERY_ADD_STUDENT, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, student.getFirstName());
                statement.setString(2, student.getLastName());
                statement.setString(3, student.getMiddleName());
                statement.setString(4, student.getGroup());
                statement.setInt(5, student.getAge());
                int addedCount = statement.executeUpdate();
                if (addedCount > 0) {
                    try (ResultSet rs = statement.getGeneratedKeys()) {
                        if (rs.next())
                            generatedId.set(rs.getLong(1));
                    }
                }
                statement.close();
                closeConnection(connection);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                closeConnection(connection);
            }
        });
        return mergeStudentWithId(generatedId.get(), student);
    }

    private Student mergeStudentWithId(Long id, Student student) {
        return Student.builder()
                .id(id)
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .middleName(student.getMiddleName())
                .group(student.getGroup())
                .age(student.getAge())
                .build();
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package ru.makhach.studentsstorage.dao;

import ru.makhach.studentsstorage.model.Student;
import ru.makhach.studentsstorage.ui.type.DeleteStatus;

import java.util.List;

/**
 * Слой для работы со студентами
 */
public interface StudentDao {
    /**
     * Имя БД со студентами
     */
    String TABLE_NAME = "students";

    /**
     * Получение всех студентов с БД
     *
     * @return список студентов
     */
    List<Student> getAllStudents();

    /**
     * Удаление студента по ID
     *
     * @param id идентификатор студента
     * @return статус удаления
     */
    DeleteStatus deleteStudentById(Long id);

    /**
     * Добавление студента в БД
     *
     * @param student модель студента
     * @return добавленного студента с присвоенным идентификатором
     */
    Student addStudent(Student student);
}

package ru.makhach.studentsstorage.ui.model;

import ru.makhach.studentsstorage.model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Кастомная модель таблицы для хранения студентов.
 */
public class StudentTableModel extends AbstractTableModel {
    private static final int COLUMN_COUNT = 6;
    private List<Student> students;

    public StudentTableModel() {
        this.students = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        if (student == null)
            return "";
        return Columns.values()[columnIndex].getValue(student);
    }

    /**
     * Устанавливает список студентов модели
     *
     * @param students список студентов
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Добавление студента в список
     * @param student модель студента
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Удаление студента по идентификатору из модели
     *
     * @param id идентификатор студента
     */
    public void removeStudentById(Long id) {
        List<Student> filteredStudents = students.stream().filter(student -> student.getId().equals(id)).collect(Collectors.toList());
        Student studentForDelete;
        if (filteredStudents.size() == 1) {
            studentForDelete = filteredStudents.get(0);
            students.remove(studentForDelete);
        }
    }

    @Override
    public String getColumnName(int column) {
        return Columns.values()[column].getDisplayedName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Columns.values()[columnIndex].getClazz();
    }

    public enum Columns {
        ID("ID", Long.class) {
            @Override
            public Object getValue(Student student) {
                return student.getId();
            }
        },
        FIRST_NAME("Имя", String.class) {
            @Override
            public Object getValue(Student student) {
                return student.getFirstName();
            }
        },
        LAST_NAME("Фамилия", String.class) {
            @Override
            public Object getValue(Student student) {
                return student.getLastName();
            }
        },
        MIDDLE_NAME("Отчество", String.class) {
            @Override
            public Object getValue(Student student) {
                return student.getMiddleName();
            }
        },
        GROUP("Группа", String.class) {
            @Override
            public Object getValue(Student student) {
                return student.getGroup();
            }
        },

        AGE("Возраст", Integer.class) {
            @Override
            public Object getValue(Student student) {
                return student.getAge();
            }
        };

        private final String displayedName;
        private final Class<?> clazz;

        Columns(String displayedName, Class<?> clazz) {
            this.displayedName = displayedName;
            this.clazz = clazz;
        }

        public String getDisplayedName() {
            return displayedName;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public abstract Object getValue(Student student);
    }
}

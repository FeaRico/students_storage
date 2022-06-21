package ru.makhach.studentsstorage.dao;

/**
 * Слой работы с БД
 */
public interface DatabaseDao {
    /**
     * Инициализирует БД, если таковой нет
     */
    void initializeDatabase();

    /**
     * Инициализирует таблицу, если таковой нет
     */
    void initializeTable();
}

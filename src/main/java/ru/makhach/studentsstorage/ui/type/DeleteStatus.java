package ru.makhach.studentsstorage.ui.type;

/**
 * Статус удаления
 */
public enum DeleteStatus {
    /**
     * Успешно
     */
    SUCCESS(1),
    /**
     * Не найден по идентификатору
     */
    NOT_FOUND_WITH_ID(2),
    /**
     * Ошибка соединения с БД
     */
    CONNECTION_ERROR(3);

    DeleteStatus(int status) {
        this.status = status;
    }

    private final int status;

    public int getStatus() {
        return status;
    }
}

package ru.makhach.studentsstorage.ui.type;

public enum DeleteStatus {
    SUCCESS(1),
    NOT_FOUND_WITH_ID(2),
    CONNECTION_ERROR(3);

    DeleteStatus(int status) {
        this.status = status;
    }

    private final int status;

    public int getStatus() {
        return status;
    }
}

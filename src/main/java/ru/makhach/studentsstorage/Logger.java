package ru.makhach.studentsstorage;

import javax.swing.*;

public class Logger {
    private static Logger instance;
    private final JFrame parent;

    private Logger(JFrame parent) {
        this.parent = parent;
    }

    public static Logger getInstance() {
        if (instance == null)
            throw new AssertionError("Необходимо вызвать метод инициализации!");
        return instance;
    }

    public synchronized static Logger init(JFrame parent) {
        if (instance != null)
            throw new AssertionError("Инстанс уже инициализирован");
        instance = new Logger(parent);

        return instance;
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(parent, msg);
    }
}

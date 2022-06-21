/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ru.makhach.studentsstorage.ui.window;

import ru.makhach.studentsstorage.dao.DatabaseDao;
import ru.makhach.studentsstorage.dao.StudentDao;
import ru.makhach.studentsstorage.dao.impl.DatabaseDaoImpl;
import ru.makhach.studentsstorage.dao.impl.StudentDaoImpl;
import ru.makhach.studentsstorage.model.Student;
import ru.makhach.studentsstorage.ui.model.StudentTableModel;
import ru.makhach.studentsstorage.ui.type.DeleteStatus;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author xamelion
 */
public class MainWindow extends javax.swing.JFrame {
    private StudentTableModel studentTableModel;
    private final DatabaseDao databaseDao;
    private final StudentDao studentDao;

    /**
     * Creates new form NewJFrame
     */
    public MainWindow() {
        this.databaseDao = new DatabaseDaoImpl();
        this.studentDao = new StudentDaoImpl();
        initComponents();
        centeredWindow(this);
        initTable();
        initDb();
        loadData();
    }

    private void loadData() {
        List<Student> students = studentDao.getAllStudents();
        studentTableModel.setStudents(students);
        studentTableModel.fireTableDataChanged();
    }

    private void initDb() {
        databaseDao.initializeDatabase();
        databaseDao.initializeTable();
    }

    private void initTable() {
        this.studentTableModel = new StudentTableModel();
        this.studentsTable.setModel(studentTableModel);
        this.studentsTable.getTableHeader().setReorderingAllowed(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addStudentDialog = new javax.swing.JDialog();
        dialogPanel = new javax.swing.JPanel();
        ageSpinner = new javax.swing.JSpinner();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        middleNameField = new javax.swing.JTextField();
        groupField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        middleNameLabel = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        addDialogButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        actionsPanel = new javax.swing.JPanel();
        idToDeleteField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        addStudentDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addStudentDialog.setTitle("Добавление студента");
        addStudentDialog.setResizable(false);
        addStudentDialog.setSize(new java.awt.Dimension(400, 300));

        ageSpinner.setModel(new javax.swing.SpinnerNumberModel(16, 10, 150, 1));

        lastNameLabel.setText("Фамилия");

        firstNameLabel.setText("Имя");

        middleNameLabel.setText("Отчество");

        groupLabel.setText("Группа");

        ageLabel.setText("Возраст");

        addDialogButton.setText("Добавить");
        addDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDialogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogPanelLayout = new javax.swing.GroupLayout(dialogPanel);
        dialogPanel.setLayout(dialogPanelLayout);
        dialogPanelLayout.setHorizontalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(middleNameLabel)
                    .addComponent(firstNameLabel)
                    .addComponent(groupLabel)
                    .addComponent(lastNameLabel)
                    .addComponent(ageLabel))
                .addGap(57, 57, 57)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(groupField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameField)
                    .addComponent(middleNameField)
                    .addGroup(dialogPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dialogPanelLayout.setVerticalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(middleNameLabel)
                    .addComponent(middleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupLabel)
                    .addComponent(groupField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addDialogButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addStudentDialogLayout = new javax.swing.GroupLayout(addStudentDialog.getContentPane());
        addStudentDialog.getContentPane().setLayout(addStudentDialogLayout);
        addStudentDialogLayout.setHorizontalGroup(
            addStudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        addStudentDialogLayout.setVerticalGroup(
            addStudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentDialogLayout.createSequentialGroup()
                .addComponent(dialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Студенты");
        setResizable(false);

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(studentsTable);

        actionsPanel.setLayout(new java.awt.GridLayout(1, 0));

        idToDeleteField.setText("id");
        idToDeleteField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idToDeleteFieldFocusGained(evt);
            }
        });
        actionsPanel.add(idToDeleteField);

        deleteButton.setText("Удалить");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        actionsPanel.add(deleteButton);

        addButton.setLabel("Добавить");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        actionsPanel.add(addButton);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDialogButtonActionPerformed
        Student student = Student.builder()
                .firstName(firstNameField.getText())
                .lastName(lastNameField.getText())
                .middleName(middleNameField.getText())
                .group(groupField.getText())
                .age((Integer) ageSpinner.getValue())
                .build();

        Student createdStudent = studentDao.addStudent(student);
        studentTableModel.addStudent(createdStudent);
        studentTableModel.fireTableDataChanged();
        addStudentDialog.dispose();
    }//GEN-LAST:event_addDialogButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String studentId = idToDeleteField.getText();
        if ("".equals(studentId))
            showMessage("Необходимо указать идентификатор для удаления!");
        else {
            DeleteStatus status = studentDao.deleteStudentById(Long.valueOf(studentId));
            switch (status) {
                case SUCCESS: {
                    showMessage("Студент успешно удалён!");
                    studentTableModel.removeStudentById(Long.valueOf(studentId));
                    studentTableModel.fireTableDataChanged();
                    break;
                }
                case NOT_FOUND_WITH_ID: {
                    showMessage("Студента с таким идентификатором нет!");
                    break;
                }
                case CONNECTION_ERROR: {
                    showMessage("Проверьте соединение с базой данных!");
                    break;
                }
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void idToDeleteFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idToDeleteFieldFocusGained
        idToDeleteField.setText("");
    }//GEN-LAST:event_idToDeleteFieldFocusGained

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        centeredWindow(addStudentDialog);
        addStudentDialog.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    public void centeredWindow(Window window) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - window.getWidth()) / 2;
        int iCoordY = (objDimension.height - window.getHeight()) / 2;
        window.setLocation(iCoordX, iCoordY);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionsPanel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addDialogButton;
    private javax.swing.JDialog addStudentDialog;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JSpinner ageSpinner;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel dialogPanel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField groupField;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JTextField idToDeleteField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField middleNameField;
    private javax.swing.JLabel middleNameLabel;
    private javax.swing.JTable studentsTable;
    // End of variables declaration//GEN-END:variables
}

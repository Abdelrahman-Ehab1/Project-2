package view;

import controller.AdminRole;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewStudents extends JFrame {
    private JPanel mainPanel;
    private JTable studentTable;

    public ViewStudents() {
        setTitle("View All Students");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());

        // Table setup
        String[] columns = {"ID", "Name", "Age", "Gender", "Department", "GPA"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        studentTable = new JTable(model);
        loadStudents(model);

        JScrollPane scrollPane = new JScrollPane(studentTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(mainPanel);
        setVisible(true);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                MainWindow main =  new MainWindow();
                main.setVisible(true); // Show previous frame
                dispose();
            }
        });

    }

    private void loadStudents(DefaultTableModel model) {
        AdminRole admin = new AdminRole();
        Student[] students = admin.getListOfStudents();

        for (Student s : students) {
            String genderText = s.isGender() ? "Male" : "Female";
            model.addRow(new Object[]{
                    s.getStudentID(), s.getName(), s.getAge(),
                    genderText, s.getDepartment(), s.getGpa()
            });
        }
    }

}
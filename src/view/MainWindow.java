package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel MainFrame;
    private JButton logoutBn;
    private JButton addStudentBn;
    private JButton updateStudentBn;
    private JButton viewStudentsBn;
    private JButton deleteStudentBn;


    public MainWindow() {
        setTitle("Main Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        //setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);   // Center the window
        setContentPane(MainFrame);
        logoutBn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame login = new LoginFrame();
                login.setVisible(true);
                // Close current window
                dispose();
            }
        });
        addStudentBn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudent addStudent = new AddStudent();
                addStudent.setVisible(true);
                dispose();

            }
        });
        viewStudentsBn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewStudents viewPage = new ViewStudents();
                viewPage.setVisible(true);
                dispose();
            }
        });
        updateStudentBn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteStudentBn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}

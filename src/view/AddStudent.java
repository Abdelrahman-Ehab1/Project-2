package view;

import controller.AdminRole;
import model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddStudent extends JFrame{
    private JPanel AddStudentPanel;
    private JTextField IDField;
    private JTextField NameField;
    private JLabel NameLabel;
    private JLabel IDLabel;
    private JTextField AgeField;
    private JLabel AgeLabel;
    private JComboBox GenderCombo;
    private JLabel GenderLabel;
    private JLabel DepartmentLabel;
    private JTextField DepartmentField;
    private JTextField GPAField;
    private JLabel GPALabel;
    private JButton saveButton;
    private JButton closeButton;
    private AdminRole Admin=new AdminRole();
    private int age=-101;
private Boolean gender;
private String name,Department,Id;
private float GPA=-1;

    public AddStudent() {
       Student [] ar1=Admin.getListOfStudents();
        setVisible(true);
        setContentPane(AddStudentPanel);
        setTitle("Add Student");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLayout(null);
        setLocationRelativeTo(null);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                GPA=Float.parseFloat(GPAField.getText());
//                age=Integer.parseInt(AgeField.getText());
                Department=DepartmentField.getText();
                String x=(String)GenderCombo.getSelectedItem();
                if("Male".equalsIgnoreCase(x))
                    gender=true;
                else if("Female".equalsIgnoreCase(x))
                    gender=false;
                else
                    gender=null;
                Id=IDField.getText();
                int u;
                name=NameField.getText();
                String [] parts =name.split(" ");
                u=parts.length;

                if (Id.isEmpty() || name.isEmpty() || gender==null || Department.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields!", "Error In Saving",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for(Student i:ar1)
                {
                    if(i.getStudentID().equalsIgnoreCase(Id)==true)
                    {
                        JOptionPane.showMessageDialog(null, "Id is already taken", "Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                if(u<2)
                {
                    JOptionPane.showMessageDialog(null, "Your Name should be more than 2 words: " + name,"Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    age = Integer.parseInt(AgeField.getText().trim());
                    if (age <= 16 || age > 60) {
                        JOptionPane.showMessageDialog(null, "Your age should be between 1 and 100: " + age,
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid number for age!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    GPA = Float.parseFloat(GPAField.getText().trim());
                    if (GPA < 0 || GPA > 4) {
                        JOptionPane.showMessageDialog(null, "You should enter GPA between 0 and 4: " + GPA,
                                "Error In GPA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid number for GPA!", "Error In GPA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Admin.addStudent(Id, name, age, gender, Department, GPA);
                JOptionPane.showMessageDialog(AddStudentPanel, "Student Added");
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow main = new MainWindow();
                main.setVisible(true);
                dispose();
            }
        });
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                MainWindow main =  new MainWindow();
                main.setVisible(true); // Show previous frame
                dispose();
            }
        });

    }

}

package view;

import controller.AdminRole;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchUpdate extends JFrame {
    private JTextField SearchField;
    private JPanel SearchUpdatePanel;
    private JLabel SearchLabel;
    private JScrollPane TableScroll;
    private JTextField ID_field;
    private JTextField Name_field;
    private JTextField Age_field;
    private JTextField Department_field;
    private JComboBox Gender_field;
    private JTextField GPA_field;
    private JTable SearchUpdateTable;
    private JButton saveButton;
    private JButton closeButton;
    private JButton SearchButton;
    private int row;
AdminRole x=new AdminRole();
    public SearchUpdate() {

        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setContentPane(SearchUpdatePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Student []ar=x.getListOfStudents();
        String [] col={"ID","Name","Age","Gender","Department","GPA"};
        DefaultTableModel Model =new DefaultTableModel(col,0);
        for(Student i:ar)
        {
            String [] f=i.lineRepresentation().split(",");
            Model.addRow(new String[]{f[0], f[1], f[2], f[3], f[4], f[5]});
        }

        SearchUpdateTable.setModel(Model);
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < ar.length; i++) {
                    if (i == row) continue;

                    if (ar[i].getStudentID().equalsIgnoreCase(ID_field.getText())) {
                        JOptionPane.showMessageDialog(null, "ID is already taken by another student!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                String [] parts=Name_field.getText().split(" ");
                int u=parts.length;
                if(u<2)
                {
                    JOptionPane.showMessageDialog(null, "Your Name should be more than 2 words: " ,"Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    if ( Integer.parseInt(Age_field.getText())<= 16 || Integer.parseInt(Age_field.getText()) > 60) {
                        JOptionPane.showMessageDialog(null, "Your age should be between 1 and 100: ", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid number for age!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    if (Float.parseFloat(GPA_field.getText()) < 0 || Float.parseFloat(GPA_field.getText()) > 4) {
                        JOptionPane.showMessageDialog(null, "You should enter GPA between 0 and 4: ",
                                "Error In GPA", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid number for GPA!", "Error In GPA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ar[row].setAge(Integer.parseInt(Age_field.getText()));
                ar[row].setGpa(Float.parseFloat(GPA_field.getText()));
                ar[row].setStudentID(ID_field.getText());
                ar[row].setName(Name_field.getText());
                ar[row].setGender(Gender_field.getSelectedItem().toString().equalsIgnoreCase("Male")?true:false);
                ar[row].setDepartment(Department_field.getText());
                x.changeStudentOfIndex(row,ar[row]);
                JOptionPane.showMessageDialog(null, "Success");

            }
        });

        SearchUpdateTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchId = SearchField.getText().trim();
                boolean found = false;

                for (int i = 0; i < ar.length; i++) {
                    if (ar[i].getStudentID().equalsIgnoreCase(searchId)) {
                        // Store the found index for later saving
                        row = i;

                        // Fill the form fields
                        ID_field.setText(ar[i].getStudentID());
                        Name_field.setText(ar[i].getName());
                        Age_field.setText(String.valueOf(ar[i].getAge()));
                        Gender_field.setSelectedItem(ar[i].isGender() ? "Male" : "Female");
                        Department_field.setText(ar[i].getDepartment());
                        GPA_field.setText(String.valueOf(ar[i].getGpa()));

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "No student found with ID: " + searchId, "Search Result", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}

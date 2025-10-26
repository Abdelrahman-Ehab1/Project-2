package view;

import controller.AdminRole;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeleteFrame extends JFrame {
    private JPanel DeleteFrame;
    private JScrollPane scroller;
    private JTable table1;
    private JButton deleteButton;

    public DeleteFrame() {
        setContentPane(DeleteFrame);
        setTitle("Delete Student");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"StudentID", "Full Name", "Age", "Gender", "Department", "GPA"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table1.setModel(model);
        loadStudentsToTable(model);

        setVisible(true);


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRowCount()==1){
                    int choice = JOptionPane.showConfirmDialog(DeleteFrame.this,"Final decision: you want to delete this entry ?","Confirm student deletion",JOptionPane.YES_NO_OPTION);

                    if(choice == 1 || choice==-1 ){ // -1 y3ny afal das 3la x  // 1 y3ny das 3la NO
                        return;
                    }

                    AdminRole admin = new AdminRole();
                    String studentId = (String) model.getValueAt(table1.getSelectedRow(), 0);
                    admin.removeStudent(studentId);
                    model.removeRow(table1.getSelectedRow());

                }

                else if(model.getRowCount()==0){
                    JOptionPane.showMessageDialog(DeleteFrame.this, "Table is already empty, Can't delete");
                }

                else if(table1.getSelectedRowCount()==0){  // btrag3 -1 lw mfesh row selected msh 0
                    JOptionPane.showMessageDialog(DeleteFrame.this,"Select student first");
                }


            }
        });


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                MainWindow main =  new MainWindow();
                main.setVisible(true); // btrag3ny lel main view lw dost 3la x
                dispose();            // bt2fl el safha el ana fatha
            }
        });
    }

    private void loadStudentsToTable(DefaultTableModel model){

        AdminRole admin = new AdminRole();
        Student [] students = admin.getListOfStudents();

        for(int i = 0 ; i<students.length ; i++){
            //Student std = students[i];
            String gender = students[i].isGender() ? "Male" : "Female";         // btcheck if male or female bl turinary operator w bttb3 fl row
            model.addRow(new Object[]{
                    students[i].getStudentID(), students[i].getName(), students[i].getAge(),
                    gender, students[i].getDepartment(), students[i].getGpa()
            });
        }
    }

}
//

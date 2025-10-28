package view;

import javax.swing.*;
import java.awt.*;
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
        setSize(900, 600);
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
                SearchUpdate searchScreen = new SearchUpdate();
                searchScreen.setVisible(true);
                dispose();
            }
        });
        deleteStudentBn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteFrame deletePage = new DeleteFrame();
                deletePage.setVisible(true);
                dispose();


            }
        });
    }

}
//MainWindow with back ground

/*package view;

import javax.swing.*;
        import java.awt.*;

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
        setSize(900, 600);
        setLocationRelativeTo(null); // center the window

        // 🟢 Load background image
        java.net.URL imgURL = getClass().getResource("/images/IMG_0422.jpeg");
        if (imgURL == null) {
            System.err.println("❌ ERROR: Could not find image! Make sure it's at src/images/IMG_0422.jpeg");
        } else {
            System.out.println("✅ Image found: " + imgURL);
        }

        ImageIcon backgroundIcon = new ImageIcon(imgURL);
        Image backgroundImage = backgroundIcon.getImage();

        // 🟢 Custom background panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // 🟢 Make your IntelliJ form transparent
        getMainFrame().setOpaque(false);

        backgroundPanel.add(getMainFrame(), BorderLayout.CENTER);
        setContentPane(backgroundPanel);

        setVisible(true);

        // Button Actions
        logoutBn.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });
        addStudentBn.addActionListener(e -> {
            new AddStudent().setVisible(true);
            dispose();
        });
        viewStudentsBn.addActionListener(e -> {
            new ViewStudents().setVisible(true);
            dispose();
        });
        updateStudentBn.addActionListener(e -> {
            new SearchUpdate().setVisible(true);
            dispose();
        });
        deleteStudentBn.addActionListener(e -> {
            new DeleteFrame().setVisible(true);
            dispose();
        });
    }

    public JPanel getMainFrame() {
        return MainFrame;
    }
}*/

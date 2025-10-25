package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JPanel LoginFrame;
    private JTextField fillUserName;
    private JPasswordField fillPassword;
    private JButton Login;

    public LoginFrame() {
        setTitle("Login");
        setContentPane(LoginFrame);
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = fillUserName.getText();
                String password = new String(fillPassword.getPassword());

                if (username.equals("boda") && password.equals("1292005")) {
                    JOptionPane.showMessageDialog(LoginFrame, "Login successful!");
                    MainWindow main = new MainWindow();  // Open the main window
                    main.setVisible(true);
                    dispose();  // Close login window
                } else {
                    JOptionPane.showMessageDialog(LoginFrame, "Invalid username or password");
                }
            }
        });

    }
}
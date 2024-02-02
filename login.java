import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class login {
    JLabel label = new JLabel("LOGIN YOUR ATTENDANCE");
    JTextField userIDField = new JTextField();
    JPasswordField password = new JPasswordField();

    public login() {
        JFrame frame = new JFrame("Attendance Management");

        JButton button = new JButton("Login");
        button.setBounds(550, 500, 100, 50);
        button.setFont(new Font("Normal", Font.BOLD, 20));
        frame.add(button);

        JLabel username = new JLabel("USER NAME");
        username.setBounds(570, 150, 400, 50);
        username.setFont(new Font("Verdana", Font.BOLD, 15));
        frame.add(username);

        userIDField.setBounds(550, 200, 500, 40);
        frame.add(userIDField);

        password.setBounds(550, 385, 500, 40);
        frame.add(password);

        JLabel passwords = new JLabel("PASSWORD");
        passwords.setBounds(570, 350, 400, 50);
        passwords.setFont(new Font("normal", Font.BOLD, 15));
        frame.add(passwords);

        JLabel attendance = new JLabel("ATTENDANCE");
        attendance.setBounds(100, 275, 400, 50);
        attendance.setFont(new Font("normal", Font.BOLD, 50));
        frame.add(attendance);

        JLabel management = new JLabel("MANAGEMENT SYSTEM");
        management.setBounds(280, 310, 400, 50);
        management.setFont(new Font("normal", Font.BOLD, 15));
        frame.add(management);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userIDField.getText();
                String pwd = new String(password.getPassword());

                boolean isAuthenticated = authenticateUser(username, pwd);

                if (isAuthenticated) {
                    label.setText("Login successful");
                } else {
                    label.setText("Invalid username or password");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 500, 1000);
        frame.add(panel);

        frame.add(userIDField);
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private boolean authenticateUser(String username, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_use", "root", "root")) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                // Execute the query and check if a matching record exists
                return preparedStatement.executeQuery().next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new login());
    }
}

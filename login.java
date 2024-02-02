import javax.swing.*;
import java.awt.Font;
import java.awt.*;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login  implements ActionListener {
    JLabel label=new JLabel("LOGIN YOUR ATTENDENCE");
    JTextField UserIDField=new JTextField();
    JButton button=new JButton("login");

    public login (){
        JFrame JFrame = new JFrame();
        JFrame frame=new JFrame("Attendence management");



        button.setBounds(550,500,100,50);
        button.setFont(new Font("Time new romen", Font.BOLD, 20));
        frame.add(button);
        button.addActionListener(this);



        JLabel username= new JLabel("USER NAME");
        username.setForeground(Color.decode("#37474D"));
        username.setBounds(570, 150, 400, 50);
        username.setFont(new Font("Verdana", Font.BOLD, 15));
        frame.add(username);

        UserIDField.setBounds(550,200,500,40);



        JPasswordField password = new JPasswordField();
        password.setBounds(550, 385, 500, 40);
        frame.add(password);


        JLabel passwords= new JLabel("PASSWORD");
        passwords.setForeground(Color.decode("#37474D"));
        passwords.setBounds(570, 350, 400, 50);
        passwords.setFont(new Font("Verdana", Font.BOLD, 15));
        frame.add(passwords);

        JLabel attendance = new JLabel("ATTENDANCE");
        attendance.setForeground(Color.decode("#37474F"));
        attendance.setBounds(100, 275, 400, 50);
        attendance.setFont(new Font("Verdana", Font.BOLD, 50));
        frame.add(attendance);


        JLabel management = new JLabel("MANAGEMENT SYSTEM");
        management.setForeground(Color.decode("#37474D"));
        management.setBounds(280, 310, 400, 50);
        management.setFont(new Font("Verdana", Font.BOLD, 15));
        frame.add(management);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 500, 1000);
        panel.setBackground(Color.decode("#DEE4E8"));
        frame.add(panel);




        frame.add(label);
        frame.add(UserIDField);
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String text;
        if(e.getSource()==button){
            text=UserIDField.getText();
            label.setText(text);
            int data=Integer.parseInt(text);
            System.out.println(data+data);
        }
    }
}



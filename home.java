

import javax.swing.*;
import java.awt.*;

public class home {
    JLabel label = new JLabel("CLICK YOUR CHOICE");
    JButton b1 = new JButton("ADD STUDENT");

    JButton b3 = new JButton("MARK ATTENDANCE");
    JButton b2 = new JButton("VIEW STUDENT");

    public home() {
        JFrame JFrame = new JFrame();
        JFrame frame = new JFrame("Attendence management");

        label.setBounds(700, 200, 500, 40);
        label.setFont(new Font("normal", Font.BOLD, 20));
        frame.add(label);

        b1.setBounds(500, 300, 700, 50);
        b1.setFont(new Font("normal", Font.BOLD, 20));
        frame.add(b1);

        b2.setBounds(500, 400, 700, 50);
        b2.setFont(new Font("normal", Font.BOLD, 20));
        frame.add(b2);

        b3.setBounds(500, 500, 700, 50);
        b3.setFont(new Font("normal", Font.BOLD, 20));
        frame.add(b3);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}


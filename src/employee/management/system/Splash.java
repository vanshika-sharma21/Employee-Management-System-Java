package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    JLabel heading;

    public Splash() {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Heading
        heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM", JLabel.CENTER);
        heading.setBounds(0, 20, 1170, 60);
        heading.setFont(new Font("Serif", Font.BOLD, 50));
        heading.setForeground(Color.RED);
        add(heading);

        // Image
        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/front.jpg")
        );
        Image i2 = i1.getImage().getScaledInstance(
                1170, 520, Image.SCALE_SMOOTH
        );
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 100, 1170, 520);
        image.setLayout(null);
        add(image);

        // Button
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(435, 380, 300, 50);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.setFocusPainted(false);
        clickhere.addActionListener(this);
        image.add(clickhere);

        // Blinking text
        Timer timer = new Timer(500, e -> {
            heading.setVisible(!heading.isVisible());
        });
        timer.start();

        // Frame
        setSize(1170, 620);
        setLocation(200, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Splash();
    }
}


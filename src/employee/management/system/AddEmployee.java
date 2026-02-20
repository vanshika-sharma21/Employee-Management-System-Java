package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfemail, tfdesignation, tfaadhar;
    JLabel lblempId;
    JDateChooser dcdob;
    JComboBox<String> cbeducation;
    JButton add, back;

    Random ran = new Random();
    int number = ran.nextInt(999999);

    AddEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(250, 20, 500, 40);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 30));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 100, 150, 30);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 100, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 100, 150, 30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 150, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 150, 150, 30);
        add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 150, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 150, 150, 30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 200, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 200, 150, 30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 200, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 200, 150, 30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 250, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 250, 150, 30);
        add(tfemail);

        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 250, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "B.Tech", "MBA", "MCA", "MA", "M.Tech"};
        cbeducation = new JComboBox<>(courses);
        cbeducation.setBounds(600, 250, 150, 30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 300, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 300, 150, 30);
        add(tfdesignation);

        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 300, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 300, 150, 30);
        add(tfaadhar);

        JLabel labelEmpId = new JLabel("Employee ID");
        labelEmpId.setBounds(50, 350, 150, 30);
        labelEmpId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmpId);

        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 350, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        add = new JButton("Add Details");
        add.setBounds(250, 450, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 450, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 600);
        setLocation(300, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {

            try {
                Conn conn = new Conn();

                String query = "insert into employee values('"
                        + tfname.getText() + "','"
                        + tffname.getText() + "','"
                        + ((JTextField) dcdob.getDateEditor().getUiComponent()).getText() + "','"
                        + tfsalary.getText() + "','"
                        + tfaddress.getText() + "','"
                        + tfphone.getText() + "','"
                        + tfemail.getText() + "','"
                        + cbeducation.getSelectedItem() + "','"
                        + tfdesignation.getText() + "','"
                        + tfaadhar.getText() + "','"
                        + lblempId.getText() + "')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details added successfully");

                dispose();   // Close AddEmployee properly
                new Home();  // Open Home again

            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
        else if (ae.getSource() == back) {

            dispose();     // Close AddEmployee
            new Home();    // Open Home (4 buttons screen)
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}

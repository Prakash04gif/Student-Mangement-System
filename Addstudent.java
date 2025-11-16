import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Addstudent extends JFrame implements ActionListener {
    JLabel heading, nameLabel, fnameLabel, rollLabel, dobLabel, addressLabel, phoneLabel, xLabel, emailLabel, xiiLabel, aadhaarLabel, courseLabel, branchLabel;
    JTextField tname, tfname, tdob, taddress, tphone, tX, temail, tXII, taadhaar;
    JLabel rollValueLabel;
    JButton submit, cancel;
    JComboBox<String> cbCourse, cbBranch;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    Addstudent() {
        // Frame settings
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        // Heading
        heading = new JLabel("New Student Information");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        // Name
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 150, 100, 30);
        add(nameLabel);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        add(tname);

        // Father's Name
        fnameLabel = new JLabel("Father's Name:");
        fnameLabel.setBounds(400, 150, 150, 30);
        add(fnameLabel);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);

        // Roll No
        rollLabel = new JLabel("Roll No:");
        rollLabel.setBounds(50, 200, 100, 30);
        add(rollLabel);

        rollValueLabel = new JLabel("1533" + first4);
        rollValueLabel.setBounds(200, 200, 150, 30);
        add(rollValueLabel);

        // Date of Birth
        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(400, 200, 150, 30);
        add(dobLabel);

        tdob = new JTextField();
        tdob.setBounds(600, 200, 150, 30);
        add(tdob);

        // Address
        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 250, 100, 30);
        add(addressLabel);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        // Contact No
        phoneLabel = new JLabel("Contact No:");
        phoneLabel.setBounds(400, 250, 150, 30);
        add(phoneLabel);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        add(tphone);

        // Email
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 300, 100, 30);
        add(emailLabel);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        add(temail);

        // X Percentage
        xLabel = new JLabel("X Percentage:");
        xLabel.setBounds(400, 300, 150, 30);
        add(xLabel);

        tX = new JTextField();
        tX.setBounds(600, 300, 150, 30);
        add(tX);

        // XII Percentage
        xiiLabel = new JLabel("XII Percentage:");
        xiiLabel.setBounds(50, 350, 150, 30);
        add(xiiLabel);

        tXII = new JTextField();
        tXII.setBounds(200, 350, 150, 30);
        add(tXII);

        // Aadhaar
        aadhaarLabel = new JLabel("Aadhaar:");
        aadhaarLabel.setBounds(400, 350, 150, 30);
        add(aadhaarLabel);

        taadhaar = new JTextField();
        taadhaar.setBounds(600, 350, 150, 30);
        add(taadhaar);

        // Course
        courseLabel = new JLabel("Select Course:");
        courseLabel.setBounds(50, 400, 150, 30);
        add(courseLabel);

        String[] courses = {"B.TECH", "BCA", "BSC", "BBA", "BCOM", "M.TECH", "MBA", "MSC", "MCOM"};
        cbCourse = new JComboBox<>(courses);
        cbCourse.setBounds(200, 400, 150, 30);
        add(cbCourse);

        // Branch
        branchLabel = new JLabel("Select Branch:");
        branchLabel.setBounds(400, 400, 150, 30);
        add(branchLabel);

        String[] branches = {"CSE", "EE", "ME", "CE", "IT", "ECE"};
        cbBranch = new JComboBox<>(branches);
        cbBranch.setBounds(600, 400, 150, 30);
        add(cbBranch);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        // Frame visibility
        setVisible(true);
    }

    // Action listener for buttons
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Submit")) {
            String name = tname.getText();
            String fname = tfname.getText();
            String roll = rollValueLabel.getText();
            String dob = tdob.getText();
            String address = taddress.getText();
            String contact = tphone.getText();
            String email = temail.getText();
            String x = tX.getText();
            String xii = tXII.getText();
            String aadhaar = taadhaar.getText();
            String course = (String) cbCourse.getSelectedItem();
            String branch = (String) cbBranch.getSelectedItem();

            try {
                // Ensure Conn class exists and is properly set up for database interaction
                String query = "INSERT INTO student VALUES ('" + name + "', '" + fname + "', '" + roll + "', '" + dob + "', '" +
                        address + "', '" + contact + "', '" + email + "', '" + x + "', '" + xii + "', '" + aadhaar + "', '" + course + "', '" + branch + "')";
                Conn conn = new Conn(); // Replace with your actual connection setup
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else if (msg.equals("Cancel")) {
            setVisible(false);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new Addstudent();
    }
}

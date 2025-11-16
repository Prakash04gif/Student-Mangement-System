import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;




public class AddTeacher  extends JFrame implements ActionListener {
    JLabel Heading, name, fname, id, lid, dob, address, phone, X, email, XII, aadhaar, course, branch;
    JTextField tname, tfname, tdob, taddress, tphone, tX, temail, tXII, taadhaar;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    JComboBox cb;
    JComboBox cbbranch;


    AddTeacher() {

        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);


        Heading = new JLabel("New teacher information");
        Heading.setBounds(310, 30, 500, 50);
        add(Heading);


        name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        add(tname);

        fname = new JLabel("Fathers Name");
        fname.setBounds(400, 150, 200, 30);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);

        id = new JLabel("id");
        id.setBounds(50, 200, 200, 30);
        add(id);

        lid = new JLabel("101" + first4);
        lid.setBounds(200, 200, 200, 30);
        add(lid);

        dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        add(dob);

        tdob = new JTextField();
        tdob.setBounds(600, 200, 200, 30);
        add(tdob);

        address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 200, 30);
        add(taddress);

        phone = new JLabel("Contact no");
        phone.setBounds(400, 250, 200, 30);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 200, 200, 30);
        add(tphone);

        email = new JLabel("Email");
        phone.setBounds(50, 300, 200, 30);
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 200, 30);
        add(temail);

        X = new JLabel("X Percentage");
        X.setBounds(400, 300, 200, 30);
        add(X);

        tX = new JTextField();
        tX.setBounds(600, 300, 200, 30);
        add(tX);

        XII = new JLabel("XII percentage");
        XII.setBounds(50, 350, 200, 30);
        add(XII);

        tXII = new JTextField();
        tXII.setBounds(200, 350, 150, 30);
        add(tXII);

        aadhaar = new JLabel("Aadhaar");
        aadhaar.setBounds(400, 350, 200, 30);
        add(aadhaar);

        taadhaar = new JTextField();
        taadhaar.setBounds(600, 350, 150, 30);
        add(taadhaar);

        course = new JLabel(" Select Course");
        course.setBounds(50, 400, 200, 30);
        add(course);
        String Course[] = {"B.TECH", "BCA", "BSC", "BBA", "BCOM", "M.TECH", "MBA", "MSC", "MCOM"};
        cb = new JComboBox<>(Course);
        cb.setBounds(200, 400, 150, 30);
        add(cb);
        setVisible(true);

        branch = new JLabel(" Select Departement");
        branch.setBounds(400, 400, 200, 30);
        add(branch);
        String branch[] = {"CSE", "EE", "ME", "CE", "IT", "ECE"};
        cbbranch = new JComboBox<>(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        add(cbbranch);


        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        String msg = ae.getActionCommand();
        if (msg.equals("Submit")) {
            String name = tname.getText();
            String fname = tfname.getText();
            String id = lid.getText();
            String dob = tdob.getText();
            String address = taddress.getText();
            String contact = tphone.getText();
            String x = tX.getText();
            String xii = tXII.getText();
            String aadhaar = taadhaar.getText();
            String course = (String) cb.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try {
                String query = "insert into teacher values('" + name + "','" + fname + "','" + id + "','" + dob + "','" + address + "','" + contact + "','" + x + "','" + xii + "','" + aadhaar + "','" + course + "','" + branch + "' ) ";
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Succesfully");
                setVisible(false);

            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddTeacher();


    }
}
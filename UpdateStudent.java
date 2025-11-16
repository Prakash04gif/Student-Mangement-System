import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;


public class UpdateStudent  extends JFrame implements ActionListener {
    JLabel Heading,name,fname,roll,lroll,dob,address,phone,X,email,XII,aadhaar,course,branch,lname,lfname,ldob,ltX,lXII,laadhaar;
    JTextField taddress,tphone,temail,tfcourse,tfbranch;
    JButton submit,cancel;

    Random ran=new Random();
    long first4= Math.abs((ran.nextLong() % 9000L) + 1000L);

    Choice croll;
    JComboBox cb;
    JComboBox cbbranch;


    UpdateStudent(){

        setSize(900,700);
        setLocation(350,50);

        setLayout(null);


        Heading =new JLabel("Update student information");
        Heading.setBounds(50,10,500,50);
        add(Heading);

        JLabel heading=new JLabel("Select Roll no. ");
        heading.setBounds(20,20,150,20);
        add(heading);

        croll=new Choice();
        croll.setBounds(180,20,150,20);
        croll.setBackground(Color.WHITE);
        add(croll);

        try{
            Conn c=new Conn();
            ResultSet rs= c.s.executeQuery("select * from student");
            while(rs.next())
            {

                croll.add(rs.getString("roll"));
            }




        }catch(Exception e){

            e.printStackTrace();
        }



        name =new JLabel("Name");
        name.setBounds(50,150,100,30);
        add(name);





        lname=new JLabel();
        lname.setBounds(200,150,150,30);
        add(lname);

        fname =new JLabel("Fathers Name");
        fname.setBounds(400,150,200,30);
        add(fname);

        lfname=new JLabel();
        lfname.setBounds(600,150,150,30);
        add(lfname);

        roll =new JLabel("Roll no");
        roll.setBounds(50,200,200,30);
        add(roll);

        lroll =new JLabel();
        lroll.setBounds(200,200,200,30);
        add(lroll);

        dob =new JLabel("Date of Birth");
        dob.setBounds(400,200,200,30);
        add(dob);

        ldob =new JLabel();
        ldob.setBounds(600,200,200,30);
        add(ldob);

        address =new JLabel("Address");
        address.setBounds(50,250,200,30);
        add(address);

        taddress =new JTextField();
        taddress.setBounds(200,250,200,30);
        add(taddress);

        phone =new JLabel("Contact no");
        phone.setBounds(400,250,200,30);
        add(phone);

        tphone =new JTextField();
        tphone.setBounds(600,200,200,30);
        add(tphone);

        email =new JLabel("Email");
        phone.setBounds(50,300,200,30);
        add(email);

        temail =new JTextField();
        temail.setBounds(200,300,200,30);
        add(temail);

        X =new JLabel("X Percentage");
        X.setBounds(400,300,200,30);
        add(X);

        ltX =new JLabel();
        ltX.setBounds(600,300,200,30);
        add(ltX);

        XII=new JLabel("XII percentage");
        XII.setBounds(50,350,200,30);
        add(XII);

        lXII=new JLabel();
        lXII.setBounds(200,350,150,30);
        add(lXII);

        aadhaar=new JLabel("Aadhaar");
        aadhaar.setBounds(400,350,200,30);
        add(aadhaar);

        laadhaar=new JLabel();
        laadhaar.setBounds(600,350,150,30);
        add(laadhaar);

        course=new JLabel( " Select Course");
        course.setBounds(50,400,200,30);
        add(course);

        tfcourse=new JTextField();
        cb.setBounds(200,400,150,30);
        add(cb);
        setVisible(true);

        branch=new JLabel( " Select Branch");
        branch.setBounds(400,400,200,30);
        add(branch);

        tfbranch=new JTextField();
        cbbranch.setBounds(600,400,150,30);
        add(cbbranch);


        submit =new JButton("Update");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel =new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        String msg=ae.getActionCommand();
        if(msg.equals("Submit")){
            String name= lname.getText();
            String fname=lfname.getText();
            String roll=lroll.getText();
            String dob=ldob.getText();
            String address=taddress.getText();
            String contact=tphone.getText();
            String x=ltX.getText();
            String xii=lXII.getText();
            String aadhaar=laadhaar.getText();
            String course=(String)cb.getSelectedItem();
            String branch=(String)cbbranch.getSelectedItem();

            try{
                String query="insert into student values('"+name+"','"+fname+"','"+roll+"','"+dob+"','"+address+"','"+contact+"','"+x+"','"+xii+"','"+aadhaar+"','"+course+"','"+branch+"' ) ";
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Details Inserted Succesfully");
                setVisible(false);

            }catch(Exception e){

                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new  UpdateStudent();


    }


}


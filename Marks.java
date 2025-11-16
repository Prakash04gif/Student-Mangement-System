import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame  {
    String rollno;
    JButton print,cancel;
    Marks(String rollno){
        this.rollno=rollno;

        setSize(500,600);
        setLocation(500,100);
        setLayout(null);
        JLabel heading=new JLabel("GRAPHIC ERA HILL UNIVERSITY");
        heading.setBounds(100,10,500,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);


        JLabel sheading=new JLabel("RESULT OF 2024");
        sheading.setBounds(100,50,500,30);
        sheading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(sheading);

        JLabel rolln=new JLabel("Roll Number"+rollno);
        rolln.setBounds(60,100,500,30);
        rolln.setFont(new Font("Tahoma",Font.BOLD,20));
        add(rolln);


        JLabel lsem=new JLabel();
        lsem.setBounds(60,130,500,30);
        lsem.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lsem);

        JLabel subj1=new JLabel();
        subj1.setBounds(100,200,500,30);
        subj1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(subj1);

        JLabel subj2=new JLabel();
        subj2.setBounds(100,230,500,30);
        subj2.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(subj2);

        JLabel subj3=new JLabel();
        subj3.setBounds(100,260,500,30);
        subj3.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(subj3);

        JLabel subj4=new JLabel();
        subj4.setBounds(100,290,500,30);
        subj4.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(subj4);

        JLabel subj5=new JLabel();
        subj5.setBounds(100,320,500,30);
        subj5.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(subj5);

        try{
            Conn c=new Conn();
            ResultSet rs1=c.s.executeQuery("select * from subject where roll='"+rollno+"'");
            while(rs1.next()){

                subj1.setText(rs1.getString("sub1"));
                subj2.setText(rs1.getString("sub2"));
                subj3.setText(rs1.getString("sub3"));
                subj4.setText(rs1.getString("sub4"));
                subj5.setText(rs1.getString("sub5"));




            }
            ResultSet rs2=c.s.executeQuery("select * from marks where roll='"+rollno+"'");
            while(rs2.next()){

                subj1.setText(subj1.getText()+"----------"+rs2.getString("marks1"));
                subj2.setText(subj2.getText()+"----------"+rs2.getString("marks2"));
                subj3.setText(subj3.getText()+"-----------"+rs2.getString("marks3"));
                subj4.setText(subj4.getText()+"----------"+rs2.getString("marks4"));
                subj5.setText(subj5.getText()+"----------"+rs2.getString("marks5"));
                lsem.setText("Semester"+rs2.getString("sem"));




            }



        }catch (Exception e){

            e.printStackTrace();
        }





        setVisible(true);

    }


    public static void main(String[] args){
        new Marks("");
    }
}

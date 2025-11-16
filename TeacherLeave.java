

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice croll,ctime;
    
    JButton submit,cancel;

    TeacherLeave(){
        setSize(500,500);
        setLocation(600,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel heading=new JLabel("Apply Leave(Teacher)");
        heading.setBounds(40,50,300,30);
        add(heading);

        JLabel lbl=new JLabel("Search by id");
        lbl.setBounds(60,100,200,20);
        add(lbl);

        croll=new Choice();
        croll.setBounds(60,140,200,20);
        croll.setBackground(Color.WHITE);
        add(croll);

        try{
            Conn c=new Conn();
            ResultSet rs= c.s.executeQuery("select * from teacher");
            while(rs.next())
            {

                croll.add(rs.getString("id"));
            }




        }catch(Exception e){

            e.printStackTrace();
        }


        JLabel lbldate=new JLabel("Select date");
        lbl.setBounds(60,120,200,20);
        add(lbldate);


        JLabel lbltime=new JLabel("Time Duration ");
        lbltime.setBounds(60,260,200,20);
        add(lbltime);

        ctime=new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.setBackground(Color.WHITE);
        ctime.add("full day");
        ctime.add("half day");
        add(ctime);

        submit=new JButton("Submit");
        submit.setBounds(60,350,100,20);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(200,350,100,20);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("Submit")){
            String id=croll.getSelectedItem();
            String duration=ctime.getSelectedItem();


            try{
                Conn c=new Conn();
                
                JOptionPane.showMessageDialog(null,"leave applied successfully");
                setVisible(false);

            }catch(Exception e){

                e.printStackTrace();
            }


        }
        else{

            setVisible(false);
        }
    }



    public static void main(String[] args){

        new TeacherLeave();
    }
}
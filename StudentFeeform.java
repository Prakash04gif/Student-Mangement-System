import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeform extends JFrame implements ActionListener {
    Choice croll;
    JComboBox cbsemester,cbcourse,cbbranch;
    JLabel total,paid;
    JButton submit,update,cancel;

    StudentFeeform(){

        setSize(900,500);
        setLocation(300,100);

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);


        JLabel lroll=new JLabel("Select Roll No");
        lroll.setBounds(40,60,150,20);
        add(lroll);

        croll=new Choice();
        croll.setBounds(200,60,150,20);
        add(croll);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){

                croll.add(rs.getString("roll"));


            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name=new JLabel("Name");
        name.setBounds(40,100,150,30);
        add(name);

        JLabel lname=new JLabel();
        lname.setBounds(200,100,150,30);
        add(lname);

        JLabel fname=new JLabel("Fathers Name");
        fname.setBounds(40,140,150,30);
        add(fname);

        JLabel lfname=new JLabel();
        lfname.setBounds(200,140,150,30);
        add(lfname);

        try{
            Conn c=new Conn();
            String query="select * from student where roll='"+croll.getSelectedItem()+"'";
            ResultSet rs =c.s.executeQuery(query);

            while(rs.next()){

                lname.setText(rs.getString("name"));
                lfname.setText(rs.getString("fname"));

            }

        }catch(Exception e){

            e.printStackTrace();
        }

        croll.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{

                    Conn c1=new Conn();
                    String query="select * from student where roll='"+croll.getSelectedItem()+"'";
                    ResultSet rs =c1.s.executeQuery(query);

                    while(rs.next()){

                        lname.setText(rs.getString("name"));
                        lfname.setText(rs.getString("fname"));

                    }

                }catch(Exception e1){

                    e1.printStackTrace();
                }
            }
        });

        JLabel lcourse = new JLabel("COURSE");
        lcourse.setBounds(40,180,150,20);
        add(lcourse);
        String course[]={ "B.TECH","BCA","BSC","BBA","BCOM","M.TECH","MBA","MSC","MCOM"};
        cbcourse=new JComboBox<>(course);
        cbcourse.setBounds(200,180,150,20);
        add(cbcourse);

        JLabel lbranch = new JLabel("Branch");
        lbranch.setBounds(40,220,150,20);
        add(lbranch);
        String branch[]={ "CSE","EE","ME","CE","IT","ECE"};
        cbbranch=new JComboBox<>(branch);
        cbbranch.setBounds(200,220,150,20);
        add(cbbranch);



        JLabel sem=new JLabel("Select Semester");
        sem.setBounds(40,260,150,30);
        add(sem);

        String semester[]={"semesterI","semesterII","semesterIII","semesterIv","semesterV","semesterVI","semesterVII","semesterVIII"};
        cbsemester=new JComboBox<>(semester);
        cbsemester.setBounds(200,260,150,20);
        add(cbsemester);



         total=new JLabel("Total Payable");
        total.setBounds(40,300,150,30);
        add(total);

        paid=new JLabel();
        paid.setBounds(200,300,150,30);
        add(paid);

        update=new JButton("Update");
        update.setBounds(30,380,100,25);
        update.addActionListener(this);
        add(update);
        submit=new JButton("Submit Fees");
        submit.setBounds(150,380,100,25);
        submit.addActionListener(this);
        add(submit);
        cancel=new JButton("Cancel");
        cancel.setBounds(270,380,100,25);
        cancel.addActionListener(this);
        add(cancel);



        setVisible(true);




    }

    public  void actionPerformed(ActionEvent ae){

            String msg= ae.getActionCommand();
            if(msg.equals("Update")){
                String course=(String) cbcourse.getSelectedItem();
                String semester=(String) cbsemester.getSelectedItem();
                try{
                    Conn c=new Conn();
                    ResultSet rs=c.s.executeQuery("select * from fees where course='"+course+"'");
                    while(rs.next()){
                        total.setText(rs.getString(semester));
                    }


                }catch(Exception e){

                    e.printStackTrace();
                }



            }
            else if(msg.equals("Submit Fees")) {
                String roll = croll.getSelectedItem();
                String course = (String) cbcourse.getSelectedItem();
                String semester = (String) cbsemester.getSelectedItem();
                String branch = (String) cbbranch.getSelectedItem();
                String tot = total.getText();
                try {
                    Conn c = new Conn();
                    String query = "insert into paidfee values('" + roll + "','" + course + "','" + branch + "','" + semester + "','" + tot + "')";

                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "College Fee Paid Successfully");
                    setVisible(false);


                } catch (Exception e) {

                    e.printStackTrace();

                }
            }
            else{

                setVisible(false);
            }



    }


    public static void main(String[] args){
        new StudentFeeform();

    }
}

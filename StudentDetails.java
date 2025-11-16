import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
public class StudentDetails extends JFrame implements ActionListener {
    Choice croll;
    JTable table;
    JButton search,print,add,cancel;



    StudentDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Search by Roll no. ");
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


        table=new JTable();


        try{
            Conn c=new Conn();
            ResultSet rs= c.s.executeQuery("select * from student");





        }catch(Exception e){

            e.printStackTrace();
        }


        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        add=new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);



        cancel=new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);




        setSize(900,700);
        setLocation(300,100);




        setVisible(true);




    }
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("Search")){
            String query = "select * from student where roll='"+croll.getSelectedItem()+"' ";
            try{
                Conn c= new Conn();
                ResultSet rs=c.s.executeQuery(query);

            }catch(Exception e){
                e.printStackTrace();

            }


        }
        else if (msg.equals("Print")) {
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        else if (msg.equals("Add")) {
            setVisible(false);
            new Addstudent();


        }

        else if (msg.equals("Cancel")) {
            setVisible(false);

        }




    }

    public static void main( String[] args)
    {
        new StudentDetails();
    }
}

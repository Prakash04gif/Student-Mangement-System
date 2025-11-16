import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class FeeStructure extends JFrame {
JButton print,cancel;
    FeeStructure(){

        setSize(1000,700);
        setLocation(250,50);

        setLayout(null);

        JLabel label=new JLabel("Fess Structure");
        label.setBounds(50,10,400,30);
        label.setFont(new Font("Tahoma",Font.BOLD,24));
        add(label);

        JTable table=new JTable();

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from fees");

        }catch(Exception e){

            e.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,60,1000,700);
        add(jsp);





        setVisible(true);




    }
    public static void main(String[] args){
        new FeeStructure();


    }

}
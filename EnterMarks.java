import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {

    Choice croll;
    JComboBox cbsem;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,cancel;



   EnterMarks(){
       setSize(1000,500);
       setLocation(300,150);

       setLayout(null);
       getContentPane().setBackground(Color.WHITE);

       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/exam.jpg"));
       Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       image.setBounds(500,40,400,300);
       add(image);

       JLabel heading=new JLabel("Enter Marks ");
       heading.setBounds(50,0,500,40);
       add(heading);

       JLabel lblroll = new JLabel("Select Roll No.");
       lblroll.setBounds(50,70,150,20);
       add(lblroll);

       croll=new Choice();
       croll.setBounds(200,70,200,20);
       croll.setBackground(Color.WHITE);
       add(croll);

       try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from student");
           while(rs.next()){
               croll.add(rs.getString("roll"));

           }


       }catch(Exception e)
       {
           e.printStackTrace();

       }

       JLabel lblsem = new JLabel("Select Semeseter.");
       lblsem.setBounds(50,110,150,20);
       add(lblsem);

       String sem[]={"I","II","III","IV","V","VI","VII","VIII"};

       cbsem=new JComboBox<>(sem);
       cbsem.setBounds(200,110,100,20);
       cbsem.setBackground(Color.WHITE);
       add(cbsem);

       JLabel lblsub = new JLabel("Enter Subject Name");
       lblsub.setBounds(100,150,200,40);
       add(lblsub);

       JLabel lblmarks = new JLabel("Enter Marks");
       lblmarks.setBounds(320,150,200,40);
       add(lblmarks);

       tfsub1=new JTextField();
       tfsub1.setBounds(50,200,200,20);
       add(tfsub1);

       tfsub2=new JTextField();
       tfsub2.setBounds(50,230,200,20);
       add(tfsub2);

       tfsub3=new JTextField();
       tfsub3.setBounds(50,260,200,20);
       add(tfsub3);

       tfsub4=new JTextField();
       tfsub4.setBounds(50,290,200,20);
       add(tfsub4);

       tfsub5=new JTextField();
       tfsub5.setBounds(50,320,200,20);
       add(tfsub5);

       tfmarks1=new JTextField();
       tfmarks1.setBounds(250,200,200,20);
       add(tfmarks1);

       tfmarks2=new JTextField();
       tfmarks2.setBounds(250,230,200,20);
       add(tfmarks2);

       tfmarks3=new JTextField();
       tfmarks3.setBounds(250,260,200,20);
       add(tfmarks3);

       tfmarks4=new JTextField();
       tfmarks4.setBounds(250,290,200,20);
       add(tfmarks4);

       tfmarks5=new JTextField();
       tfmarks5.setBounds(250,320,200,20);
       add(tfmarks5);

       submit=new JButton("Submit");
       submit.setBounds(70,360,150,25);
       submit.addActionListener(this);
       add(submit);

       cancel=new JButton("Cancel");
       cancel.setBounds(260,360,150,30);
       cancel.addActionListener(this);
       add(cancel);







       setVisible(true);


   }

   public void actionPerformed(ActionEvent ae){

       try{
           String msg=ae.getActionCommand();
           if(msg.equals("Submit")){
               try{
                   Conn c=new Conn();
                   String query1="insert into subject values('"+croll.getSelectedItem()+"','"+cbsem.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"') ";
                   String query2="insert into marks values('"+croll.getSelectedItem()+"','"+cbsem.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"') ";

                   c.s.executeUpdate(query1);
                   c.s.executeUpdate(query2);

                   JOptionPane.showMessageDialog(null,"Marks Uploaded Successfully ");

               }catch(Exception e){

                   e.printStackTrace();
               }


           }

           else if(msg.equals("Cancel")){
               setVisible(false);

           }

       }catch(Exception e){

           e.printStackTrace();
       }


   }






    public static void main(String[] args){

        new EnterMarks();
    }

}

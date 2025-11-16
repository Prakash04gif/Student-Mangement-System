import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
JButton login,cancel;
JTextField tusername,tpassword;
    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lbl=new JLabel("Username");
        lbl.setBounds(40,20,100,20);
        add(lbl);
        tusername=new JTextField();
        tusername.setBounds(150,20,150,20);
        add(tusername);

        JLabel passlbl=new JLabel("Password");
        passlbl.setBounds(40,70,100,20);
        add(passlbl);
         tpassword=new JPasswordField();
        tpassword.setBounds(150,70,150,20);
        add(tpassword);


        JButton login =new JButton("login");
        login.setBounds(40,140,120,30);

        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        JButton cancel =new JButton("cancel");
        cancel.setBounds(180,140,120,30);




        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);


        setSize(600,300);
        setLocation(500,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae ){
        String msg=ae.getActionCommand();

        if(msg.equals("cancel")){
            setVisible(false);
        }
else if(msg.equals("login"))
{
String username=tusername.getText();
String password=tpassword.getText();

String query ="select * from login where username='"+username+"'and password='"+password+"'";

try{
    Conn c=new Conn();
     ResultSet rs =c.s.executeQuery(query);

     if(rs.next()){
         setVisible(false);
         new Project();
     }
     else{
         JOptionPane.showMessageDialog(null,"invalid username or passwprd");
         setVisible(false);


     }

}catch(Exception e){

    e.printStackTrace();
}


}

    }


    public static void main(String[] args){

        new Login();
    
    }
}


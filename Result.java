import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Result extends JFrame implements ActionListener {
    JTextField search;
    JButton view,cancel;
    JTable table;


    Result(){

        setSize(1000,475);
        setLocation(300,100);
        setLayout(null);

        JLabel heading=new JLabel("RESULT");
        heading.setBounds(80,15,400,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        search =new JTextField();
        search.setBounds(80,90,200,35);
        add(search);

        view=new JButton("View");
        view.setBounds(300,90,120,25);
        view.addActionListener(this);
        add(view);

        cancel=new JButton("Cancel");
        cancel.setBounds(440,90,120,20);
        cancel.addActionListener(this);
        add(cancel);

        table =new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));

        JScrollPane jsc=new JScrollPane(table);
        jsc.setBounds(0,140,1000,300);
        add(jsc);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");


        }catch(Exception e){
            e.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });




        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("View"))
        {
            new Marks(search.getText());
            setVisible(false);

        }
        else if(msg.equals("Cancel")){

            setVisible(false);
        }

    }

    public static void main(String[] args)
    {

        new Result();

    }
}

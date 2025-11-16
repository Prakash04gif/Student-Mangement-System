import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    // Constructor
    Project() {
        // Set frame size and layout
        setSize(1540, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure application closes properly

        // Adding background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // Creating the menu bar
        JMenuBar m = new JMenuBar();

        // Menu: New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        m.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        // Menu: Leave Pass
        JMenu leave = new JMenu("Leave Pass");
        leave.setForeground(Color.BLUE);
        m.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave Pass");
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave Pass");
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // Menu: Details
        JMenu details = new JMenu("Details");
        details.setForeground(Color.BLUE);
        m.add(details);

        JMenuItem facultyDetails = new JMenuItem("Faculty Details");
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("Student Details");
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        // Menu: Leave Pass Details
        JMenu leaveDetails = new JMenu("Leave Pass Details");
        leaveDetails.setForeground(Color.BLUE);
        m.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        // Menu: Exam Details
        JMenu exams = new JMenu("Exam Details");
        exams.setForeground(Color.BLUE);
        m.add(exams);

        JMenuItem marks = new JMenuItem("Enter Student Marks");
        marks.addActionListener(this);
        exams.add(marks);

        JMenuItem result = new JMenuItem("RESULT");
        result.addActionListener(this);
        exams.add(result);

        // Menu: Fee Details
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        m.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeDetails = new JMenuItem("Fee");
        feeDetails.addActionListener(this);
        fee.add(feeDetails);

        // Menu: Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        m.add(utility);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.addActionListener(this);
        utility.add(calculator);

        // Menu: Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.PINK);
        m.add(exit);

        JMenuItem ex = new JMenuItem("exit");
        ex.addActionListener(this);
        exit.add(ex);

        // Set menu bar to the frame
        setJMenuBar(m);

        // Make frame visible
        setVisible(true);
    }

    // Action performed method
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        try {
            if (msg.equals("exit")) {
                setVisible(false);
                dispose(); // Properly close the frame
            } else if (msg.equals("Calculator")) {
                Runtime.getRuntime().exec("calc.exe");
            } else if (msg.equals("New Faculty Information")) {
                new AddTeacher();
            } else if (msg.equals("Student Leave Pass")) {
                new StudentLeave();
            } else if (msg.equals("Faculty Leave Pass")) {
                new TeacherLeave();
            } else if (msg.equals("Faculty Leave Details")) {
                new TeacherLeaveDetails();
            } else if (msg.equals("Student Leave Details")) {
                new StudentLeaveDetails();
            } else if (msg.equals("Enter Student Marks")) {
                new EnterMarks();
            } else if (msg.equals("Student Details")) {
                new StudentDetails();
            } else if (msg.equals("Faculty Details")) {
                new TeacherDetails();
            } else if (msg.equals("Fee Structure")) {
                new FeeStructure();
            }
            } else if (msg.equals("Fee")) {
                new StudentFeeform();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        new Project();
    }
}

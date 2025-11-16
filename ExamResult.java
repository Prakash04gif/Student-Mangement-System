import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ExamResult extends JFrame implements ActionListener {

    Choice croll;
    JComboBox<String> cbsem;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5;
    JTextField tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    JButton submit, cancel;

    ExamResult() {
        setSize(1000, 500);
        setLocation(300, 150);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        JLabel heading = new JLabel("Enter Marks ");
        heading.setBounds(50, 0, 500, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblroll = new JLabel("Select Roll No.");
        lblroll.setBounds(50, 70, 150, 20);
        add(lblroll);

        croll = new Choice();
        croll.setBounds(200, 70, 200, 20);
        croll.setBackground(Color.WHITE);
        add(croll);

        // Populate roll numbers from the database
        try (Connection conn = new Connection() {
            @Override
            public Statement createStatement() throws SQLException {
                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql) throws SQLException {
                return null;
            }

            @Override
            public CallableStatement prepareCall(String sql) throws SQLException {
                return null;
            }

            @Override
            public String nativeSQL(String sql) throws SQLException {
                return "";
            }

            @Override
            public void setAutoCommit(boolean autoCommit) throws SQLException {

            }

            @Override
            public boolean getAutoCommit() throws SQLException {
                return false;
            }

            @Override
            public void commit() throws SQLException {

            }

            @Override
            public void rollback() throws SQLException {

            }

            @Override
            public void close() throws SQLException {

            }

            @Override
            public boolean isClosed() throws SQLException {
                return false;
            }

            @Override
            public DatabaseMetaData getMetaData() throws SQLException {
                return null;
            }

            @Override
            public void setReadOnly(boolean readOnly) throws SQLException {

            }

            @Override
            public boolean isReadOnly() throws SQLException {
                return false;
            }

            @Override
            public void setCatalog(String catalog) throws SQLException {

            }

            @Override
            public String getCatalog() throws SQLException {
                return "";
            }

            @Override
            public void setTransactionIsolation(int level) throws SQLException {

            }

            @Override
            public int getTransactionIsolation() throws SQLException {
                return 0;
            }

            @Override
            public SQLWarning getWarnings() throws SQLException {
                return null;
            }

            @Override
            public void clearWarnings() throws SQLException {

            }

            @Override
            public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
                return null;
            }

            @Override
            public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
                return null;
            }

            @Override
            public Map<String, Class<?>> getTypeMap() throws SQLException {
                return Map.of();
            }

            @Override
            public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

            }

            @Override
            public void setHoldability(int holdability) throws SQLException {

            }

            @Override
            public int getHoldability() throws SQLException {
                return 0;
            }

            @Override
            public Savepoint setSavepoint() throws SQLException {
                return null;
            }

            @Override
            public Savepoint setSavepoint(String name) throws SQLException {
                return null;
            }

            @Override
            public void rollback(Savepoint savepoint) throws SQLException {

            }

            @Override
            public void releaseSavepoint(Savepoint savepoint) throws SQLException {

            }

            @Override
            public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
                return null;
            }

            @Override
            public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
                return null;
            }

            @Override
            public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
                return null;
            }

            @Override
            public Clob createClob() throws SQLException {
                return null;
            }

            @Override
            public Blob createBlob() throws SQLException {
                return null;
            }

            @Override
            public NClob createNClob() throws SQLException {
                return null;
            }

            @Override
            public SQLXML createSQLXML() throws SQLException {
                return null;
            }

            @Override
            public boolean isValid(int timeout) throws SQLException {
                return false;
            }

            @Override
            public void setClientInfo(String name, String value) throws SQLClientInfoException {

            }

            @Override
            public void setClientInfo(Properties properties) throws SQLClientInfoException {

            }

            @Override
            public String getClientInfo(String name) throws SQLException {
                return "";
            }

            @Override
            public Properties getClientInfo() throws SQLException {
                return null;
            }

            @Override
            public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
                return null;
            }

            @Override
            public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
                return null;
            }

            @Override
            public void setSchema(String schema) throws SQLException {

            }

            @Override
            public String getSchema() throws SQLException {
                return "";
            }

            @Override
            public void abort(Executor executor) throws SQLException {

            }

            @Override
            public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

            }

            @Override
            public int getNetworkTimeout() throws SQLException {
                return 0;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }
        };
             PreparedStatement pst = conn.prepareStatement("SELECT roll FROM student");
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                croll.add(rs.getString("roll"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblsem = new JLabel("Select Semester");
        lblsem.setBounds(50, 110, 150, 20);
        add(lblsem);

        String[] sem = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII" };
        cbsem = new JComboBox<>(sem);
        cbsem.setBounds(200, 110, 100, 20);
        cbsem.setBackground(Color.WHITE);
        add(cbsem);

        JLabel lblsub = new JLabel("Enter Subject Name");
        lblsub.setBounds(100, 150, 200, 40);
        add(lblsub);

        JLabel lblmarks = new JLabel("Enter Marks");
        lblmarks.setBounds(320, 150, 200, 40);
        add(lblmarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 200, 200, 20);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 230, 200, 20);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 260, 200, 20);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 290, 200, 20);
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 320, 200, 20);
        add(tfsub5);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250, 200, 200, 20);
        add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250, 230, 200, 20);
        add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250, 260, 200, 20);
        add(tfmarks3);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250, 290, 200, 20);
        add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(250, 320, 200, 20);
        add(tfmarks5);

        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(260, 360, 150, 30);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Submit")) {
            String rollNo = croll.getSelectedItem();
            String semester = (String) cbsem.getSelectedItem();

            String[] subjects = {
                tfsub1.getText(), tfsub2.getText(), tfsub3.getText(),
                tfsub4.getText(), tfsub5.getText()
            };

            String[] marks = {
                tfmarks1.getText(), tfmarks2.getText(), tfmarks3.getText(),
                tfmarks4.getText(), tfmarks5.getText()
            };

            try (Connection conn = Conn.getConnection()) {
                // Insert subjects
                String query1 = "INSERT INTO subject (roll, semester, sub1, sub2, sub3, sub4, sub5) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pst1 = conn.prepareStatement(query1)) {
                    pst1.setString(1, rollNo);
                    pst1.setString(2, semester);
                    for (int i = 0; i < subjects.length; i++) {
                        pst1.setString(i + 3, subjects[i]);
                    }
                    pst1.executeUpdate();
                }

                // Insert marks
                String query2 = "INSERT INTO marks (roll, semester, marks1, marks2, marks3, marks4, marks5) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pst2 = Conn.prepareStatement(query2)) {
                    pst2.setString(1, rollNo);
                    pst2.setString(2, semester);
                    for (int i = 0; i < marks.length; i++) {
                        pst2.setString(i + 3, marks[i]);
                    }
                    pst2.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Marks Uploaded Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Cancel")) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}

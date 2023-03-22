import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentDB extends JFrame implements ActionListener {
   
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "password";

   
    JLabel nameLabel, dobLabel, genderLabel, mobileLabel, branchLabel;
    JTextField nameField, dobField, genderField, mobileField, branchField;
    JButton addButton, updateButton, displayButton;
    JTextArea displayArea;

    // Database connection
    Connection conn = null;
    Statement stmt = null;

    public StudentDB() {
        // Initialize Swing components
        nameLabel = new JLabel("Name:");
        dobLabel = new JLabel("Date of Birth:");
        genderLabel = new JLabel("Gender:");
        mobileLabel = new JLabel("Mobile No.:");
        branchLabel = new JLabel("Branch Code:");
        nameField = new JTextField(20);
        dobField = new JTextField(10);
        genderField = new JTextField(1);
        mobileField = new JTextField(10);
        branchField = new JTextField(2);
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        displayButton = new JButton("Display");
        displayArea = new JTextArea(20, 40);

        // Add action listeners to buttons
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        displayButton.addActionListener(this);

        // Add Swing components to layout
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(genderLabel);
        inputPanel.add(genderField);
        inputPanel.add(mobileLabel);
        inputPanel.add(mobileField);
        inputPanel.add(branchLabel);
        inputPanel.add(branchField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(displayButton);

        JPanel displayPanel = new JPanel();
        displayPanel.add(new JScrollPane(displayArea));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(displayPanel, BorderLayout.CENTER);

        // Set up the window
        setTitle("Student Database");
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Connect to the database
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Insert a new record into the STUDENT table
            String name = nameField.getText();
            String dob = dobField.getText();
            String gender = genderField.getText();
            String mobile = mobileField.getText();
            String branch = branchField.getText();

            String sql = "INSERT INTO STUDENT (NAME, DATE_OF_BIRTH, GENDER, MOBILE_NO, BRANCH_CODE) " +
                         "VALUES ('" + name + "', '" + dob + "', '" + gender + "', '" + mobile + "', " + branch + ")";
            try {
                stmt.executeUpdate(sql);
                displayArea
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    } else if (e.getSource() == updateButton) {
        // Update the mobile number of a student
        String mobile = mobileField.getText();
        String rollno = JOptionPane.showInputDialog("Enter Roll No. to update mobile no.");
        String sql = "UPDATE STUDENT SET MOBILE_NO='" + mobile + "' WHERE ROLLNO=" + rollno;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    } else if (e.getSource() == displayButton) {
        // Display all records from the STUDENT table
        String sql = "SELECT * FROM STUDENT";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            displayArea.setText("");
            while (rs.next()) {
                String rollno = rs.getString("ROLLNO");
                String name = rs.getString("NAME");
                String dob = rs.getString("DATE_OF_BIRTH");
                String gender = rs.getString("GENDER");
                String mobile = rs.getString("MOBILE_NO");
                String branch = rs.getString("BRANCH_CODE");
                displayArea.append(rollno + "\t" + name + "\t" + dob + "\t" + gender + "\t" + mobile + "\t" + branch + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

public static void main(String[] args) {
    StudentDB studentDB = new StudentDB();
    studentDB.setVisible(true);
}

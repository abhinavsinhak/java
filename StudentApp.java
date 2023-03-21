
// Importing packages
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;

// Creating connection class
class ConnectionManager {
    // Method to connect to database
    public static Connection connectDB() {
        try {
            // Loading and registering driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Creating connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Sushant@12");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }
}

// Creating main class
public class StudentApp extends JFrame implements ActionListener{

    // Declaring component
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;

    // Creating connection object
    Connection con = null;

    // Constructor
    public StudentApp() {
        // Setting title
        super("Student App");

        // Setting layout
        setLayout(new GridLayout(4, 2));

        // Initializing components
        l1 = new JLabel("ID");
        l2 = new JLabel("Name");
        l3 = new JLabel("Marks");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        b1 = new JButton("Create Table");
        b2 = new JButton("Insert Record");
        b3 = new JButton("Update Record");

        // Adding components to frame
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        add(b3); 
        b1.addActionListener(this);

b2.addActionListener(this);

b3.addActionListener(this);

// Connecting to database

con = ConnectionManager.connectDB();

// Setting size and visibility of frame

setSize(300, 200);

setVisible(true);

}

// Implementing actionPerformed method

public void actionPerformed(ActionEvent ae) {

try {

// Getting source of action

Object source = ae.getSource();

// Creating statement object

PreparedStatement ps = null;

// Checking which button was clicked

if (source == b1) {

// SQL query to create table

String sql = "create table if not exists student(id int primary key,name varchar(20), marks int)";

ps = con.prepareStatement(sql);

ps.execute();

JOptionPane.showMessageDialog(this,"Table created successfully");

} else if (source == b2) {

// Getting data from text fields

int id = Integer.parseInt(t1.getText());

String name = t2.getText();

int marks = Integer.parseInt(t3.getText());

// SQL query to insert record

String sql ="insert into student values (?, ?, ?)";

ps =

con.prepareStatement(sql);

ps.setInt(1,

id);

ps.setString(2,

name);

ps.setInt(3,

marks);

ps.executeUpdate();

JOptionPane.showMessageDialog(this,"Record inserted successfully");

} else if (source == b3) {

// Getting data from text fields

int id =

Integer.parseInt(t1.getText());

String name =

t2.getText();

int marks =

Integer.parseInt(t3.getText());

// SQL query to update record

String sql ="update student set name=?, marks=? where id=?";

ps =

con.prepareStatement(sql);

ps.setString(1,

name);

ps.setInt(2,

marks);

ps.setInt(3,

id);

ps.executeUpdate();

JOptionPane.showMessageDialog(this,"Record updated successfully");

}

} catch (

SQLException e)

{

System.out.println(e);

}

}

public static void main(String[] args)

{

new StudentApp();

}

}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class jdbcprogram {
    public static void main(String[] args) {
        // Replace with your database URL, username and password
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "Sushant@12";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255),"
                + "email VARCHAR(255)"
                + ")";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            // Create a new table
            stmt.execute(sql);
            System.out.println("Table created successfully");

            // Insert data into the table
            stmt.executeUpdate("INSERT INTO users(name,email) VALUES('John Doe', 'john.doe@example.com')");
            System.out.println("Data inserted successfully");

            // Update data in the table
            stmt.executeUpdate("UPDATE users SET name='Jane Doe' WHERE id=1");
            System.out.println("Data updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a JTable to display data from the database
        Object[][] data = {{"John Doe", "john.doe@example.com"}};
        String[] columnNames = {"Name", "Email"};
        JTable table = new JTable(data, columnNames);

        // Create a JFrame to display the JTable
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }
}
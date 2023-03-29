import java.sql.*;

public class InsertCustomer {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/mydatabase";

   static final String USER = "username";
   static final String PASS = "password";

   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;
      try {
         Class.forName(JDBC_DRIVER);

         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         stmt = conn.createStatement();

         String sql = "INSERT INTO Customers (customer_id, customer_name) " +
               "VALUES (1234, 'John Smith')";

         stmt.executeUpdate(sql);
         System.out.println("Customer inserted successfully!");
      } catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (stmt != null)
               conn.close();
         } catch (SQLException se) {
         }
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }
      }
   }
}

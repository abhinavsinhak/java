import java.util.*;
import java.sql.*;


public class jdbcprogram 
{
    public static void main(String[] args)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println("Class not found");
        }

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","Sushant@12");
            Statement stm = con.createStatement();

            int r = stm.executeUpdate("create table student(name varchar(30),regno varchar(10),branch varchar(20))");
            System.out.println("Table Student Created");

            System.out.println("\nTables in Database:");
            ResultSet rs1 = stm.executeQuery("Show tables");
            while(rs1.next())
            {
                String tables = rs1.getString("Tables_in_practice");
                System.out.println(tables);
            }
            rs1.close();
            
            stm.execute("insert into student values('sanjog','21ME1035','Mechanical')");
            stm.execute("insert into student values('ram','21CH1209','Civil')");
            stm.execute("insert into student values('Sham','21CS1267','CSE')");
            ResultSet rs2 = stm.executeQuery("select * from student");
            System.out.println("\nData in Table Student:");
            while(rs2.next())
            {
                String name = rs2.getString("name");
                String reg = rs2.getString("regno");
                String branch = rs2.getString("branch");

                System.out.println(name + "  " + reg + "   " + branch);
            }
            rs2.close();
            
      System.out.println("\nUpdating row 21CH1209 is from Chemical:");
            r = stm.executeUpdate("update student set branch='Chemical'                                                                                  where regno='21CH1209'");
         ResultSet rs3 = stm.executeQuery("select * from student");
         System.out.println("\nData in Table Student after update:");
            while(rs3.next())
            {
                String name = rs3.getString("name");
                String reg = rs3.getString("regno");
                String branch = rs3.getString("branch");

                System.out.println(name + "  " + reg + "   " + branch);
            }


            con.close();
        } catch(SQLException e){
            System.out.println("Error!!!   " + e);
        }
    }
}

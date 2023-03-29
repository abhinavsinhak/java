import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class newfile {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root","sushant12" );
            Statement stm = con.createStatement();
            stm.executeQuery("CREATE TABLE student(name varchar(30),regno varchar(30),branch varchar(20)");
        }
        catch(SQLException e){
                System.out.println("error!!  " +e);
        }
    }
}

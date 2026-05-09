import java.sql.*;
 public class Dbconnection{
    public static Connection getconnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details","root","root");
    }
}
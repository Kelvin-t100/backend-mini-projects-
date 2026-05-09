import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class register extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
      PrintWriter dis=res.getWriter(); 
       try{            
         Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_project","root","root");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String query="insert into user_password (name,password) values(?,?)";
        PreparedStatement prep=connect.prepareStatement(query);
        prep.setString(1, name);
        prep.setString(2, password);
        prep.executeUpdate();
        res.sendRedirect("registered.html");
    }catch(Exception e){
    e.printStackTrace(dis);
    }
}
}

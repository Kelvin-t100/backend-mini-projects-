import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;

public class register extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String phone=req.getParameter("phone");
        String role=req.getParameter("role");
        int salary=Integer.parseInt(req.getParameter("salary"));
    
        try{
            Connection con=Dbconnection.getconnection();
            String query="insert into details(name,password,ph_no,role,salary) values(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, phone);
            ps.setString(4, role);
            ps.setInt(5, salary);
            ps.executeUpdate();
            req.setAttribute("name",name);
            RequestDispatcher rd=req.getRequestDispatcher("registered.jsp");
            rd.forward(req,res);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

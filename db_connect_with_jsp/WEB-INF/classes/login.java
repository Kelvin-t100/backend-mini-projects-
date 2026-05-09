import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;

public class login extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        HttpSession session=req.getSession();
        try{  
        Connection con=Dbconnection.getconnection();
        validate(name.trim(),password.trim(),con,session,res);
        }catch(Exception e){
            PrintWriter dis=res.getWriter();
            e.printStackTrace();
        }
    }

public static boolean validate(String name,String password, Connection con,HttpSession session,HttpServletResponse res){
    try{
        if(name==null){
            return false;
        }
        String query="select  * from details where name=? and password=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
           session.setAttribute("phone",rs.getString("ph_no"));
           session.setAttribute("role",rs.getString("role"));
           session.setAttribute("salary",rs.getString("salary"));
           res.sendRedirect("loggedin.jsp");
        }
        
    }
    catch(Exception e){
        e.printStackTrace();
    } res.sendRedirect("error.jsp");
}
}
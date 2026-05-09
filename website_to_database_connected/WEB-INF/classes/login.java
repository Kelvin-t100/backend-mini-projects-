import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class login extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
        PrintWriter display=res.getWriter();
     try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_project","root","root");
        HttpSession session=req.getSession();
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        if(namecheck(connect,name,display)){
            if(passcheck(connect,password,name,display)){
              session.setAttribute("name",name);
              session.setAttribute("password",password);
              res.sendRedirect("dashboard");
            }else
                res.sendRedirect("pass_err.html");
         
        }
        else{
            res.sendRedirect("errorname.html");
        }
    
        }catch(Exception e){
        e.printStackTrace(display);
        }
}
public boolean namecheck(Connection con,String name,PrintWriter dis){
    try{
    String query="select * from user_password where name=?";
    PreparedStatement prep=con.prepareStatement(query);
    prep.setString(1, name);
    ResultSet set=prep.executeQuery();
    return (set.next()?true:false);}
    catch(Exception e){
        e.printStackTrace(dis);
        return false;
    }
}

public boolean passcheck(Connection con,String paswor,String nam, PrintWriter dis){
    try{
    String query="select * from user_password where name=? and password=?";
    PreparedStatement prep=con.prepareStatement(query);
    prep.setString(1,nam);
    prep.setString(2, paswor);
    ResultSet set=prep.executeQuery();
    if(set.next()){
        System.out.println("DEBUGGGG");
        System.out.println("name"+nam+" password"+ paswor+" parameter");
        System.out.println("name"+set.getString("name")+" password"+ set.getString("password")+" DB");
        return true;
    }else
    return false;}
    catch(Exception e){
        e.printStackTrace(dis);return false;
    }
}
}

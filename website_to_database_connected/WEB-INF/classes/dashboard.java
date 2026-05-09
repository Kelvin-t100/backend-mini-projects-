import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class dashboard extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException{
        res.setContentType("text/html");
        HttpSession session=req.getSession(false);
        PrintWriter display=res.getWriter();
        if(session==null||session.getAttribute("name")==null){
            res.sendRedirect("index.html");
        }else{
            display.println("<h1>hi "+ session.getAttribute("name")+" welcome back!</h1>");
            display.println("<h3>what's on your mind</h3>");
            display.println("<br><br><h3>go back??</h3>");
            display.println("<a href='logout'>Logout??</a>");
        }
    }
    
}

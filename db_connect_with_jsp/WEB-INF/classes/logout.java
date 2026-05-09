import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class logout extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
        HttpSession session=req.getSession(false);
        if(session!=null)
            session.invalidate();
        res.sendRedirect("index.jsp");
    }
    
}

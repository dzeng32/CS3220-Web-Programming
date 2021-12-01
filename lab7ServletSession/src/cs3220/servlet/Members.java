package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Members() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = (String) request.getSession().getAttribute("user");
		if(user == null) {
			response.sendRedirect("Login");
			return;
		}
		else {
			out.println("<html><head><title>Members</title></head><body>");
			out.println("<h1>Welcome to the Members Area</h1><br>");
			out.println("<a href='Logout'>Logout</a>");
			out.println("</body></html>");
		}
	}

}

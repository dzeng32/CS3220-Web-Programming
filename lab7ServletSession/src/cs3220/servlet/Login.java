package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = (String) request.getAttribute("user");
		
		if(user == null) {
			out.println("<html><head><title>Login</title></head><body>");
			out.println("<form action='Login' method='post'>");
			out.println("Username: <input type = 'text' name = 'username'><br>");
			out.println("Password: <input type = 'password' name = 'password'><br>");
			out.println("<button>Login</button>");
			out.println("</form></body></html>");
		}
		else {
			response.sendRedirect("Members");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("cysun") && password.equals("abcd")) {
			request.getSession().setAttribute("user", username);
			response.sendRedirect("Members");
		}
		else {
			response.sendRedirect("Login");
		}
	}

}

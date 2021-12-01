package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdditionPractice")
public class AdditionPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdditionPractice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType( "text/html" );
		
		Random num = new Random();
		int firstNum = num.nextInt(9) + 1;
		int secondNum = num.nextInt(9) + 1;
		int total = firstNum + secondNum;
		
		PrintWriter out = response.getWriter();
		
		out.println( "<html><head><title>Addition Practice</title></head><body><form method='post'>" );
		
		out.print("<p> " + firstNum + " + " + secondNum + " = "
				+ "<input type='text' name='answer'> <input type='submit' name='Submit'> </p>");
		out.println("<input type='hidden' name='firstNum' value='" + firstNum + "'>");
		out.println("<input type='hidden' name='secondNum' value='" + secondNum + "'>");
		out.println("<input type='hidden' name='total' value='" + total + "'>");
        out.println( "</form></body></html>" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" );
		
		PrintWriter out = response.getWriter();
		
		int firstNum = Integer.parseInt(request.getParameter("firstNum"));
		int secondNum = Integer.parseInt(request.getParameter("secondNum"));
		int total = Integer.parseInt(request.getParameter("total"));
		
		out.println( "<html><head><title>Addition Practice</title></head><body>" );
		
		String userInput = request.getParameter("answer");
		int ans = userInput == null || userInput.trim().length() == 0 ? 0
	            : Integer.parseInt( userInput );
			
		out.println("<p> " + firstNum + " + " + secondNum + " = " + total + "</p>");
		if(total == ans)
			out.println("<p> Your answer " + ans + " is correct!</p>");
		else
			out.println("<p> Your answer " + ans + " is wrong!</p>");

		out.println("<a href='./AdditionPractice'>Try again</a>");
        out.println( "</body></html>" );
	}

}

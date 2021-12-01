package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.ListStoryEntry;

@WebServlet("/SubmitStory")
public class SubmitStory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubmitStory() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Submit Story</title></head><body>");
		out.println("<form action = 'SubmitStory' method = 'post'>");
		out.println("<table border = 1>");
		out.println("<tr>");
		out.println("<th>Title</th>");
		out.println("<td><input type='text' name = 'title' size='55'> </td> </tr>");
		out.println("<tr>");
		out.println("<th>Subtitle</th>");
		out.println("<td><input type='text' name = 'subtitle' size='55'> </td> </tr>");
		out.println("<tr>");
		out.println("<th>Content</th>");
		out.println("<td><textarea rows = '4' cols='40' name = 'content'> </textarea></td> </tr>");
		out.println("<tr>");
		out.println("<td colspan = '2'><button>Submit</button> </td> </tr>");
		out.println("</table></form>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String content = request.getParameter("content");
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		
		ListStoryEntry entry = new ListStoryEntry(title, subtitle, content);
		entry.setSubmitDate(formatter.format(date).toString());

		@SuppressWarnings("unchecked")
		List<ListStoryEntry> entries = (List<ListStoryEntry>) getServletContext().getAttribute("entries");
		entries.add(0, entry);
		response.sendRedirect("ListStory");
	}

}

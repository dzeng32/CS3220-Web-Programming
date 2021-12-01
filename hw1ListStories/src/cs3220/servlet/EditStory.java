package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.ListStoryEntry;

@WebServlet("/EditStory")
public class EditStory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditStory() {
		super();
	}

	private ListStoryEntry getEntry(int id) {
		@SuppressWarnings("unchecked")
		List<ListStoryEntry> entries = (List<ListStoryEntry>) getServletContext().getAttribute("entries");

		for(ListStoryEntry entry : entries) {
			if(entry.getId() == id) return entry;
		}
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");
		ListStoryEntry entry = getEntry(Integer.parseInt(id));
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Edit Story</title></head><body>");
		out.println("<form action = 'EditStory' method = 'post'>");
		out.println("<input type = 'hidden' name = 'id' value = '" + id + "'>");
		out.println("<table border = 1>");
		out.println("<tr>");
		out.println("<th>Title</th>");
		out.println("<td><input type='text' name = 'title' size='55' value='" + entry.getStoryTitle() + "'> </td> </tr>");
		out.println("<tr>");
		out.println("<th>Subtitle</th>");
		out.println("<td><input type='text' name = 'subtitle' size='55' value='" + entry.getSubTitle() + "'> </td> </tr>");
		out.println("<tr>");
		out.println("<th>Content</th>");
		out.println("<td><textarea rows = '4' cols='40' name = 'content'>" + entry.getStoryContent() + "</textarea></td> </tr>");
		out.println("<tr>");
		out.println("<td colspan = '2'><button>Save</button> </td> </tr>");
		out.println("</table></form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ListStoryEntry entry = getEntry(Integer.parseInt(request.getParameter("id")));
		entry.setStoryTitle(request.getParameter("title"));
		entry.setSubTitle(request.getParameter("subtitle"));
		entry.setStoryContent(request.getParameter("content"));
		response.sendRedirect("ListStory");
	}

}

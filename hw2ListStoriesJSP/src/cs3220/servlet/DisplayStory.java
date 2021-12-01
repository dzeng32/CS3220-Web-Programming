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

@WebServlet("/DisplayStory")
public class DisplayStory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayStory() {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");
		ListStoryEntry entry = getEntry(Integer.parseInt(id));
		request.setAttribute("entry", entry);
		
		request.getRequestDispatcher("/WEB-INF/DisplayStory.jsp").forward(request, response);

//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>Display Story</title></head><body>");
//		out.println("<a href='ListStory'>Back to Stories </a>");
//		out.println("<p><strong>" + entry.getStoryTitle() + "</strong></p>");
//		out.println("<p><em>" + entry.getSubTitle() + "</em></p>");
//		out.println("<p>" + entry.getStoryContent() + "</p>");

	}

}

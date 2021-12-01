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
		request.setAttribute("entry", entry);

		request.getRequestDispatcher("/WEB-INF/EditStory.jsp").forward(request, response);

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

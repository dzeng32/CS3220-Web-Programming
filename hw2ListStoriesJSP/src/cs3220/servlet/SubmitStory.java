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

		request.getRequestDispatcher("/WEB-INF/SubmitStory.jsp").forward(request, response);

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

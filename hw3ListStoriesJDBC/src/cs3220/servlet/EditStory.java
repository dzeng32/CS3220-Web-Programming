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
import cs3220.service.DbServiceListStory;

@WebServlet("/EditStory")
public class EditStory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditStory() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		DbServiceListStory dbService = new DbServiceListStory();
		request.setAttribute("entry", dbService.getEntry(id));
		dbService.close();

		request.getRequestDispatcher("/WEB-INF/EditStory.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String content = request.getParameter("content");
		
		DbServiceListStory dbService = new DbServiceListStory();
		dbService.updateEntry(id, title, subtitle, content);
		dbService.close();
		
		response.sendRedirect("ListStory");
	}

}

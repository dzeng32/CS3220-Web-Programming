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

@WebServlet("/DisplayStory")
public class DisplayStory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayStory() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		DbServiceListStory dbService = new DbServiceListStory();
		request.setAttribute("entry", dbService.getEntry(id));
		dbService.close();
		
		request.getRequestDispatcher("/WEB-INF/DisplayStory.jsp").forward(request, response);

	}
}
